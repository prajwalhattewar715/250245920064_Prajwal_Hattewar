package com.example.ecommerce.service;

import com.example.ecommerce.dto.OrderItemRequest;
import com.example.ecommerce.dto.OrderRequest;
import com.example.ecommerce.model.*;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepo;
    private final ProductRepository productRepo;
    public OrderService(OrderRepository orderRepo, ProductRepository productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }

    @Transactional
    public Order placeOrder(OrderRequest req) {
        // basic validation
        List<OrderItem> items = req.getItems().stream().map(i -> {
            Product p = productRepo.findById(i.getProductId()).orElseThrow(() -> new IllegalArgumentException("Product not found: " + i.getProductId()));
            if (p.getQuantity() < i.getQuantity()) throw new IllegalArgumentException("Insufficient stock for product: " + p.getName());
            p.setQuantity(p.getQuantity() - i.getQuantity());
            productRepo.save(p);
            OrderItem oi = new OrderItem();
            oi.setProductId(p.getId());
            oi.setProductName(p.getName());
            oi.setQuantity(i.getQuantity());
            oi.setPrice(p.getPrice());
            return oi;
        }).collect(Collectors.toList());

        BigDecimal total = items.stream()
                .map(it -> it.getPrice().multiply(BigDecimal.valueOf(it.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Order o = new Order();
        o.setCustomerId(req.getCustomerId());
        o.setOrderItems(items);
        o.setTotalAmount(total);
        o.setOrderDate(Instant.now());
        o.setStatus(OrderStatus.PENDING);
        items.forEach(it -> it.setOrder(o));
        return orderRepo.save(o);
    }

    public Order get(Long id) { return orderRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Order not found")); }
    public List<Order> listByCustomer(Long customerId) { return orderRepo.findByCustomerId(customerId); }

    public Order updateStatus(Long orderId, OrderStatus status) {
        Order o = get(orderId);
        o.setStatus(status);
        return orderRepo.save(o);
    }

    public void cancelOrder(Long orderId) {
        Order o = get(orderId);
        if (o.getStatus() == OrderStatus.SHIPPED || o.getStatus() == OrderStatus.DELIVERED) {
            throw new IllegalArgumentException("Cannot cancel shipped/delivered order");
        }
        o.getOrderItems().forEach(oi -> {
            productRepo.findById(oi.getProductId()).ifPresent(p -> {
                p.setQuantity(p.getQuantity() + oi.getQuantity());
                productRepo.save(p);
            });
        });
        o.setStatus(OrderStatus.CANCELLED);
        orderRepo.save(o);
    }
}

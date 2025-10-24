package com.example.ecommerce.controller;

import com.example.ecommerce.dto.OrderRequest;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.OrderStatus;
import com.example.ecommerce.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService svc;
    public OrderController(OrderService svc) { this.svc = svc; }

    @PostMapping
    public ResponseEntity<Order> place(@RequestBody OrderRequest req) {
        return ResponseEntity.ok(svc.placeOrder(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> get(@PathVariable Long id) {
        return ResponseEntity.ok(svc.get(id));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Order>> listByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(svc.listByCustomer(customerId));
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<Order> updateStatus(@PathVariable Long orderId, @RequestBody String status) {
        OrderStatus os = OrderStatus.valueOf(status.replace("\"", "").trim());
        return ResponseEntity.ok(svc.updateStatus(orderId, os));
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> cancel(@PathVariable Long orderId) {
        svc.cancelOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}

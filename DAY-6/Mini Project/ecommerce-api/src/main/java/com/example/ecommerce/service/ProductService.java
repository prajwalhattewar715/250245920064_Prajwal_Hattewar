package com.example.ecommerce.service;

import com.example.ecommerce.dto.CreateProductRequest;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;
    public ProductService(ProductRepository repo) { this.repo = repo; }

    public Product create(CreateProductRequest req) {
        Product p = new Product();
        p.setName(req.getName());
        p.setDescription(req.getDescription());
        p.setPrice(req.getPrice());
        p.setQuantity(req.getQuantity());
        p.setCategory(req.getCategory());
        return repo.save(p);
    }

    public Product get(Long id) { return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found")); }
    public List<Product> list() { return repo.findAll(); }
    public void delete(Long id) { repo.deleteById(id); }
}

package com.example.ecommerce.controller;

import com.example.ecommerce.dto.CreateProductRequest;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService svc;
    public ProductController(ProductService svc) { this.svc = svc; }

    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody CreateProductRequest req) {
        return ResponseEntity.ok(svc.create(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) {
        return ResponseEntity.ok(svc.get(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> list() {
        return ResponseEntity.ok(svc.list());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        svc.delete(id);
        return ResponseEntity.noContent().build();
    }
}

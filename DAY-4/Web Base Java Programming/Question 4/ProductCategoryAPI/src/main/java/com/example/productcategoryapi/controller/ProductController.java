package com.example.productcategoryapi.controller;
import com.example.productcategoryapi.entity.Product;
import com.example.productcategoryapi.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) { this.productService = productService; }
    @GetMapping
    public List<Product> getAllProducts() { return productService.getAllProducts(); }
    @PostMapping
    public Product addProduct(@RequestBody Product product) { return productService.addProduct(product); }
    @GetMapping("/range")
    public List<Product> getProductsByPriceRange(@RequestParam double min, @RequestParam double max) {
        return productService.getProductsByPriceRange(min, max);
    }
    @PutMapping("/{id}/price")
    public ResponseEntity<Product> updateProductPrice(@PathVariable Long id, @RequestParam double price) {
        return productService.updateProductPrice(id, price)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
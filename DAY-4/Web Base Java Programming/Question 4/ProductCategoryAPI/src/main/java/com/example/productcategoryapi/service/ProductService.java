package com.example.productcategoryapi.service;
import com.example.productcategoryapi.entity.Product;
import com.example.productcategoryapi.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) { this.productRepository = productRepository; }
    public List<Product> getAllProducts() { return productRepository.findAll(); }
    public Product addProduct(Product product) { return productRepository.save(product); }
    public List<Product> getProductsByPriceRange(double min, double max) { return productRepository.findByPriceBetween(min, max); }
    public Optional<Product> updateProductPrice(Long id, double newPrice) {
        Optional<Product> productOpt = productRepository.findById(id);
        productOpt.ifPresent(product -> {
            product.setPrice(newPrice);
            productRepository.save(product);
        });
        return productOpt;
    }
}
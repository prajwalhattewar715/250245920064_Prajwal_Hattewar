package com.example.productcategoryapi.repository;
import com.example.productcategoryapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByPriceBetween(double min, double max);
}
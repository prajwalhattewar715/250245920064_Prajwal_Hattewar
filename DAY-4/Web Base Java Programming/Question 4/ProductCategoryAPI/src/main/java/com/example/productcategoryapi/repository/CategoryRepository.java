package com.example.productcategoryapi.repository;
import com.example.productcategoryapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {}
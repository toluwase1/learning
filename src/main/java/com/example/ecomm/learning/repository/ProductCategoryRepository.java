package com.example.ecomm.learning.repository;

import com.example.ecomm.learning.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
     List<ProductCategory> findCategoryByCategoryName (String categoryName);
}

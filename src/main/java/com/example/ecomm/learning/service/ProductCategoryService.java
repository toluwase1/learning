package com.example.ecomm.learning.service;

import com.example.ecomm.learning.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryService {
    void addCategory (ProductCategory productCategory);
    void deleteCategory (Long id);
}

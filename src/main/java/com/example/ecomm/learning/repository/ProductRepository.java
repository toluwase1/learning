package com.example.ecomm.learning.repository;

import com.example.ecomm.learning.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductByName(String name);
}

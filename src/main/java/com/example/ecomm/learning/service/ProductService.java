package com.example.ecomm.learning.service;

import com.example.ecomm.learning.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    void addProduct (Product product);
    Product getProductById (long id) throws Exception;
    void deleteProductById(long id);
    void updateProduct(Product employee, Long id);

}

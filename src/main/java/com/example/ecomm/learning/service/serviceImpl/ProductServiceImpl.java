package com.example.ecomm.learning.service.serviceImpl;

import com.example.ecomm.learning.model.Product;
import com.example.ecomm.learning.repository.ProductRepository;
import com.example.ecomm.learning.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();

    }

    @Override
    public void addProduct(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public Product getProductById(long id) throws Exception{
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(()-> new Exception("no product found"));
    }

    @Override
    public void deleteProductById(long id) {
        this.productRepository.deleteById(id);
//        productRepository.delete(productRepository.findById(id).get());
    }

    @Override
    public void updateProduct(Product product, Long id) {
        Optional<Product> productOptional  = productRepository.findById(id);
        if (productOptional.isPresent()) {
            product.setId(id);
            productRepository.save(product);
        }
    }
}

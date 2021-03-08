package com.example.ecomm.learning.service.serviceImpl;

import com.example.ecomm.learning.model.ProductCategory;
import com.example.ecomm.learning.repository.ProductCategoryRepository;
import com.example.ecomm.learning.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public void addCategory(ProductCategory productCategory) {
        this.productCategoryRepository.save(productCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        this.productCategoryRepository.deleteById(id);
        productCategoryRepository.delete(productCategoryRepository.findById(id).get());
    }


}

package com.audittest.demo.product;

import com.audittest.demo.category.Category;
import com.audittest.demo.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public boolean create(Product payload) {
        try {
            Category category = categoryRepository.findById(1L).get();
            Product product = new Product(payload.getName(), payload.getPrice(), category);
            productRepository.save(product);
            return true;
        }catch (Exception e) {
            return false;
        }
    }



}

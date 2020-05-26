package com.audittest.demo.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    final
    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public boolean create(CategoryRequest payload) {
        try {
            Category product = new Category(payload);
            categoryRepository.save(product);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}

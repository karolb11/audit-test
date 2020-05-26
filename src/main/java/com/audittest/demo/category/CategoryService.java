package com.audittest.demo.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    final
    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void create(Category payload) {
        Category product = new Category(payload.getName(), payload.getDescription());
        categoryRepository.save(product);
    }

    public Optional<Category> readById(Long id) {
        return categoryRepository.findById(id);
    }

}

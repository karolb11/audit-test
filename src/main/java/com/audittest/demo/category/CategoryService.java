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

    public boolean create(Category payload) {
        try {
            Category product = new Category(payload.getName(), payload.getDescription());
            categoryRepository.save(product);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public Category read(Long id) throws Exception {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new Exception("not found"));
    }

}

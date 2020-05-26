package com.audittest.demo.category;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    void saveCategoryInRepo(CategoryRequest categoryRequest) {
        Category category = mapCategoryRequestToCategory(categoryRequest);
        saveCategoryInRepo(category);
    }

    Category mapCategoryRequestToCategory(CategoryRequest categoryRequest) {
        return new Category(categoryRequest.getName(), categoryRequest.getDescription());
    }

    void saveCategoryInRepo(Category category) {
        categoryRepository.save(category);
    }

    public Category findCategoryById(Long id) throws Exception {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new Exception("Category id doesnt exist"));
    }

}

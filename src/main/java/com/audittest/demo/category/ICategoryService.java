package com.audittest.demo.category;

public interface ICategoryService {
    Category save(Category category);
    Category findById(Long id);
}

package com.audittest.demo.category;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    Category save(Category category) {
        return categoryRepository.save(category);
    }

}

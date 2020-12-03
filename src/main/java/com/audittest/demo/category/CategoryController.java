package com.audittest.demo.category;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {

    private final ICategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    CategoryDTO create(@RequestBody CategoryDTO categoryDTO) {
        Category category = categoryMapper.mapToCategory(categoryDTO);
        Category savedCategory = categoryService.save(category);
        return categoryMapper.mapToCategoryDTO(savedCategory);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    CategoryDTO findById(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        return categoryMapper.mapToCategoryDTO(category);
    }
}

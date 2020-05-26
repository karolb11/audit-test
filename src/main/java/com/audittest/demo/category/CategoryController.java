package com.audittest.demo.category;

import com.audittest.demo.util.CRUDController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/category")
public class CategoryController extends CRUDController<Category> {

    final
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/newCategory")
    public ResponseEntity<?> saveNewCategory(@RequestBody Category category) {
        return create(categoryService::create, category);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCategoryById(@PathVariable("id") Long id) {
        return handleReadRequest(categoryService::read, id);
    }
}

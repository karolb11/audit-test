package com.audittest.demo.category;

import com.audittest.demo.product.ProductController;
import com.audittest.demo.product.ProductRepository;
import com.audittest.demo.util.CRUDController;
import com.audittest.demo.util.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/category")
public class CategoryController extends CRUDController {

    final
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/createNewCategory")
    public ResponseEntity<?> createNewCategory(@RequestBody Payload request) {
        return create(categoryService::create, request);
    }
}

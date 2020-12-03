package com.audittest.demo.category;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


public class CategoryNotFoundException extends Exception {
    @Getter
    private final String message;
    CategoryNotFoundException(Long id) {
        this.message = "Category not found, id: " + id;
    }
}

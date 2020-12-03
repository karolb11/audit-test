package com.audittest.demo.category;

import com.audittest.demo.product.ProductDTO;
import lombok.Data;

import java.util.Set;

@Data
public class CategoryDTO {
    private Long id;
    private String name;
    private String description;
}

package com.audittest.demo.product;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private Float price;
    private Long categoryId;
}

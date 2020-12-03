package com.audittest.demo.product;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {
    private String name;
    private Float price;
    private Long categoryId;
}

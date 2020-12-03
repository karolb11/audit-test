package com.audittest.demo.product;

public interface IProductService {
    Product save(Product product);
    Product findById(Long id);
}

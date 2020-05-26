package com.audittest.demo.product;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public boolean create(Product payload) {
        try {
            Product product = new Product(payload.getName(), payload.getPrice());
            productRepository.save(product);
            return true;
        }catch (Exception e) {
            return false;
        }
    }



}

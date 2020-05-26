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

    public boolean create(ProductRequest payload) {
        try {
            Product product = new Product(payload);
            productRepository.save(product);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Transactional
    public boolean update(ProductRequest payload) {
        try {
            Product product = productRepository.findByName(payload.getName()).get();
            product.update(payload);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}

package com.audittest.demo;

import com.audittest.demo.category.Category;
import com.audittest.demo.category.CategoryRepository;
import com.audittest.demo.product.Product;
import com.audittest.demo.product.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Test
    void inserCategory() {
        Category food = new Category("food", "food desc");
        Category alcohol = new Category("alcohol", "alcohol desc");
        categoryRepository.save(food);
        categoryRepository.save(alcohol);
    }

    @Test
    void insertProducts() {
        Product bread = new Product();
        bread.setName("bread");
        bread.setPrice(2F);
        bread.setCategory(categoryRepository.findByName("food").get());
        productRepository.save(bread);
    }

    @Test
    void select() {
        Iterable<Product> products = productRepository.findAll();
        Iterable<Category> categories = categoryRepository.findAll();
        products.forEach(i -> System.out.println(i.getId()));
    }

}

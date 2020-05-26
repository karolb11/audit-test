package com.audittest.demo.product;

import com.audittest.demo.category.Category;
import com.audittest.demo.category.CategoryRepository;
import com.audittest.demo.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    final
    ProductRepository productRepository;
    final
    CategoryService CategoryService;

    ProductService(ProductRepository productRepository, CategoryService CategoryService) {
        this.productRepository = productRepository;
        this.CategoryService = CategoryService;
    }

    void saveProductInRepo(ProductRequest productRequest) throws Exception {
        Product product = mapProductRequestToProduct(productRequest);
        saveProductInRepo(product);
    }

    void saveProductInRepo(Product product) {
        productRepository.save(product);
    }


    Product mapProductRequestToProduct(ProductRequest productRequest) throws Exception {
        Category category = CategoryService.findCategoryById(productRequest.getCategoryId());
        return new Product(productRequest.getName(), productRequest.getPrice(), category);
    }

    public Product findProductById(Long id) throws Exception {
        return productRepository.findById(id)
                .orElseThrow(() -> new Exception("Product id doesnt exist"));
    }

}

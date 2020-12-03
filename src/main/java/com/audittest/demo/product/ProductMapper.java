package com.audittest.demo.product;

import com.audittest.demo.category.Category;
import com.audittest.demo.category.CategoryRepository;
import com.audittest.demo.category.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ProductMapper {
    final
    ProductRepository productRepository;
    final
    CategoryRepository categoryRepository;

    Product productDTOToProduct(ProductDTO productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElse(null);
        return Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .category(category)
                .build();
    }
}

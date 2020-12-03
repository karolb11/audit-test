package com.audittest.demo.product;

import com.audittest.demo.category.Category;
import com.audittest.demo.category.CategoryMapper;
import com.audittest.demo.category.CategoryNotFoundException;
import com.audittest.demo.category.CategoryService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(uses = {ProductMapper.class, CategoryMapper.class},
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class ProductMapper {

    @Autowired
    private CategoryService categoryService;

    @Mapping(source = "categoryId", target = "category.id")
    abstract Product mapToProduct(ProductDTO productDTO);

    @InheritConfiguration(name="mapToProduct")
    @Mapping(ignore = true, target = "id")
    abstract Product mapToProductIgnoreId(ProductDTO productDTO);

    @InheritInverseConfiguration(name = "mapToProduct")
    @Mapping(source = "category.name", target = "categoryName")
    abstract ProductDTO mapToProductDTO(Product product);

    @Mapping(ignore = true, target = "id")
    abstract void updateProductFromDTO(ProductDTO productDTO, @MappingTarget Product product);

    @AfterMapping
    void afterProductDtoToProductMapping(ProductDTO productDTO, @MappingTarget Product product) {
        if (productDTO.getCategoryId() != null) {
            Category category = categoryService.findById(productDTO.getCategoryId());
            product.setCategory(category);
        }
    }

}

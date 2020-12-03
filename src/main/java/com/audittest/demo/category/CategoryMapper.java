package com.audittest.demo.category;

import com.audittest.demo.product.Product;
import com.audittest.demo.product.ProductDTO;
import com.audittest.demo.product.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(uses = {CategoryMapper.class, ProductMapper.class},componentModel = "spring")
public interface CategoryMapper {

    Category mapToCategory(CategoryDTO categoryDTO);

    @InheritInverseConfiguration(name = "mapToCategory")
    CategoryDTO mapToCategoryDTO(Category category);


}

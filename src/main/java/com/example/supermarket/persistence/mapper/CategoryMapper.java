package com.example.supermarket.persistence.mapper;

import com.example.supermarket.domain.Category;
import com.example.supermarket.persistence.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({ //
            @Mapping(source = "categoryId", target = "categoryId"), //
            @Mapping(source = "description", target = "description"), //
            @Mapping(source = "active", target = "active") //
    })
    Category toCategory(CategoryEntity categoryEntity);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    CategoryEntity toCategoria(Category category);
}
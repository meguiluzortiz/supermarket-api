package com.example.supermarket.service.mapper;

import com.example.supermarket.persistence.entity.CategoryEntity;
import com.example.supermarket.web.dto.Category;

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
  Category toResponse(CategoryEntity categoryEntity);

  @InheritInverseConfiguration
  @Mapping(target = "products", ignore = true)
  CategoryEntity toEntity(Category category);
}

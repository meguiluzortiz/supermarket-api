package com.example.supermarket.service.mapper;

import com.example.supermarket.persistence.entity.ProductEntity;
import com.example.supermarket.web.dto.ProductIdResponse;
import com.example.supermarket.web.dto.ProductRequest;
import com.example.supermarket.web.dto.ProductResponse;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = { CategoryMapper.class })
public interface ProductMapper {

  @Mappings({ //
      @Mapping(source = "productId", target = "productId"), //
      @Mapping(source = "name", target = "name"), //
      @Mapping(source = "price", target = "price"), //
      @Mapping(source = "stock", target = "stock"), //
      @Mapping(source = "active", target = "active"), //
      @Mapping(source = "categoryId", target = "categoryId"), //
      @Mapping(source = "category", target = "category") //
  })
  ProductResponse toResponse(ProductEntity entity);

  List<ProductResponse> toListResponse(List<ProductEntity> entities);

  @InheritInverseConfiguration
  @Mapping(target = "category", ignore = true)
  ProductEntity toEntity(ProductRequest request);

  @Mappings({ //
      @Mapping(source = "productId", target = "productId"), //
  })
  ProductIdResponse toIdResponse(ProductEntity entity);

}
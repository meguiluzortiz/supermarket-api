package com.example.supermarket.persistence.mapper;

import com.example.supermarket.domain.Product;
import com.example.supermarket.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { CategoryMapper.class })
public interface ProductMapper {

    @Mappings({ //
            @Mapping(source = "productId", target = "productId"), //
            @Mapping(source = "name", target = "name"), //
            @Mapping(source = "categoryId", target = "categoryId"), //
            @Mapping(source = "price", target = "price"), //
            @Mapping(source = "stock", target = "stock"), //
            @Mapping(source = "active", target = "active"), //
            @Mapping(source = "category", target = "category") //
    })
    Product toProduct(ProductEntity productEntity);

    List<Product> toProducts(List<ProductEntity> productos);

    @InheritInverseConfiguration
    @Mapping(target = "barcode", ignore = true)
    ProductEntity toProductEntity(Product product);
}
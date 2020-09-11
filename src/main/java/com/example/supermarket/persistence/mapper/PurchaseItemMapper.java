package com.example.supermarket.persistence.mapper;

import com.example.supermarket.domain.PurchaseItem;
import com.example.supermarket.persistence.entity.PurchaseItemEntity;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = { ProductMapper.class })
public interface PurchaseItemMapper {

  @Mappings({ //
      @Mapping(source = "purchaseItemId.productId", target = "productId"), //
      @Mapping(source = "quantity", target = "quantity"), //
      @Mapping(source = "active", target = "active") //
  })
  PurchaseItem toPurchaseItem(PurchaseItemEntity producto);

  @InheritInverseConfiguration
  @Mappings({ //
      @Mapping(target = "purchase", ignore = true), //
      @Mapping(target = "product", ignore = true), //
      @Mapping(target = "purchaseItemId.purchaseId", ignore = true) //
  })
  PurchaseItemEntity toComprasProducto(PurchaseItem item);
}
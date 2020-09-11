package com.example.supermarket.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

import com.example.supermarket.domain.Purchase;
import com.example.supermarket.persistence.entity.PurchaseEntity;

@Mapper(componentModel = "spring", uses = { PurchaseItemMapper.class })
public interface PurchaseMapper {

  @Mappings({ //
      @Mapping(source = "purchaseId", target = "purchaseId"), //
      @Mapping(source = "clientId", target = "clientId"), //
      @Mapping(source = "date", target = "date"), //
      @Mapping(source = "paymentMethod", target = "paymentMethod"), //
      @Mapping(source = "comment", target = "comment"), //
      @Mapping(source = "state", target = "state"), //
      @Mapping(source = "items", target = "items") //
  })
  Purchase toPurchase(PurchaseEntity purchaseEntity);

  List<Purchase> toPurchases(List<PurchaseEntity> listPurchaseEntity);

  @InheritInverseConfiguration
  @Mapping(target = "client", ignore = true)
  PurchaseEntity toPurchaseEntity(Purchase purchase);
}

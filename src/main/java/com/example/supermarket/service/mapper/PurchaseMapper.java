package com.example.supermarket.service.mapper;

import com.example.supermarket.persistence.entity.PurchaseEntity;
import com.example.supermarket.web.dto.PurchaseRequest;
import com.example.supermarket.web.dto.PurchaseResponse;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

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
  PurchaseResponse toResponse(PurchaseEntity entity);

  List<PurchaseResponse> toListResponse(List<PurchaseEntity> entities);

  @InheritInverseConfiguration
  @Mapping(target = "purchaseId", ignore = true)
  @Mapping(target = "client", ignore = true)
  PurchaseEntity toEntity(PurchaseRequest purchase);

}

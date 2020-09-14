package com.example.supermarket.service;

import com.example.supermarket.persistence.repository.PurchaseRepository;
import com.example.supermarket.service.mapper.PurchaseMapper;
import com.example.supermarket.web.dto.PurchaseListResponse;
import com.example.supermarket.web.dto.PurchaseRequest;
import com.example.supermarket.web.dto.PurchaseResponse;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
  @Autowired
  private PurchaseMapper mapper;

  @Autowired
  private PurchaseRepository purchaseRepository;

  public PurchaseListResponse findAll() {
    var entityList = purchaseRepository.findAll();
    var data = mapper.toListResponse(entityList);

    return new PurchaseListResponse(data.size(), data);
  }

  public Optional<PurchaseListResponse> findByClientId(String clientId) {
    var entityList = purchaseRepository.findByClientId(clientId);
    var data = entityList.map(e -> mapper.toListResponse(e));

    return data.map(e -> new PurchaseListResponse(e.size(), e));
  }

  public PurchaseResponse save(PurchaseRequest request) {
    var entity = mapper.toEntity(request);
    entity.getItems().forEach(producto -> producto.setPurchase(entity));

    var createdPurchaseEntity = purchaseRepository.save(entity);
    return mapper.toResponse(createdPurchaseEntity);

  }
}
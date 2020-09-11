package com.example.supermarket.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.example.supermarket.domain.Purchase;
import com.example.supermarket.domain.repository.PurchaseRepository;
import com.example.supermarket.persistence.crud.PurchaseCrudRepository;
import com.example.supermarket.persistence.entity.PurchaseEntity;
import com.example.supermarket.persistence.mapper.PurchaseMapper;

@Repository
public class PurchaseRepositoryImpl implements PurchaseRepository {
  @Autowired
  private PurchaseCrudRepository compraCrudRepository;

  @Autowired
  private PurchaseMapper mapper;

  @Override
  public Optional<List<Purchase>> getAll() {
    var puchases = (List<PurchaseEntity>) compraCrudRepository.findAll();
    return Optional.of(mapper.toPurchases(puchases));
  }

  @Override
  public Optional<List<Purchase>> getByClient(String clientId) {
    return compraCrudRepository.findByClientId(clientId).map(compras -> mapper.toPurchases(compras));
  }

  @Override
  public Purchase save(Purchase purchase) {
    var purchaseEntity = mapper.toPurchaseEntity(purchase);
    purchaseEntity.getItems().forEach(producto -> producto.setPurchase(purchaseEntity));
    
    var createdPurchaseEntity = compraCrudRepository.save(purchaseEntity);
    return mapper.toPurchase(createdPurchaseEntity);
  }
}

package com.example.supermarket.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

import com.example.supermarket.persistence.entity.PurchaseEntity;

public interface PurchaseCrudRepository extends CrudRepository<PurchaseEntity, Integer> {
    Optional<List<PurchaseEntity>> findByClientId(String clientId);
}

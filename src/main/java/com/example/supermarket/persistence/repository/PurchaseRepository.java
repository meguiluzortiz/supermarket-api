package com.example.supermarket.persistence.repository;

import com.example.supermarket.persistence.entity.PurchaseEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<PurchaseEntity, Integer> {
    Optional<List<PurchaseEntity>> findByClientId(String clientId);
}

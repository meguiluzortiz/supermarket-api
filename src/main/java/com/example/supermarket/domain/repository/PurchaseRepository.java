package com.example.supermarket.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.supermarket.domain.Purchase;

public interface PurchaseRepository {
    Optional<List<Purchase>> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);
}

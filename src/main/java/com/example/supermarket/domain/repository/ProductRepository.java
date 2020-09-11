package com.example.supermarket.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.supermarket.domain.Product;

public interface ProductRepository {
    Optional<List<Product>> getAll();

    Optional<List<Product>> getByCategory(int categoryId);

    Optional<List<Product>> getScarceProducts(int quantity);

    Optional<Product> getOne(int id);

    Product save(Product product);

    void delete(int productId);
}

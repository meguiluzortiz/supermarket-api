package com.example.supermarket.persistence.repository;

import com.example.supermarket.persistence.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

  @EntityGraph(attributePaths = "category")
  List<ProductEntity> findAll();

  @EntityGraph(attributePaths = "category")
  Optional<List<ProductEntity>> findByCategoryIdOrderByNameAsc(int categoryId);

  List<ProductEntity> findByStockLessThanAndActive(int stock, boolean active);
}
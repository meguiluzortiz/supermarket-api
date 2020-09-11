package com.example.supermarket.persistence.crud;

import java.util.List;
import java.util.Optional;
import com.example.supermarket.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {

    Optional<List<ProductEntity>> findByCategoryIdOrderByNameAsc(int idCategoria);

    Optional<List<ProductEntity>> findByStockLessThanAndActive(int cantidadStock, boolean estado);
}
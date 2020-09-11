package com.example.supermarket.persistence;

import java.util.List;
import java.util.Optional;

import com.example.supermarket.domain.Product;
import com.example.supermarket.domain.repository.ProductRepository;
import com.example.supermarket.persistence.crud.ProductCrudRepository;
import com.example.supermarket.persistence.entity.ProductEntity;
import com.example.supermarket.persistence.mapper.ProductMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private ProductCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public Optional<List<Product>> getAll() {
        List<ProductEntity> productos = (List<ProductEntity>) productoCrudRepository.findAll();
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        Optional<List<ProductEntity>> productos = productoCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
        return productos.map(e -> mapper.toProducts(e));
    }

    @Override
    public Optional<List<Product>> getScarceProducts(int quantity) {
        Optional<List<ProductEntity>> productos = productoCrudRepository.findByStockLessThanAndActive(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getOne(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        ProductEntity producto = mapper.toProductEntity(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }

}

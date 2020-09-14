package com.example.supermarket.service;

import com.example.supermarket.persistence.repository.ProductRepository;
import com.example.supermarket.service.mapper.ProductMapper;
import com.example.supermarket.web.dto.ProductIdResponse;
import com.example.supermarket.web.dto.ProductListResponse;
import com.example.supermarket.web.dto.ProductRequest;
import com.example.supermarket.web.dto.ProductResponse;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired
  private ProductMapper mapper;

  @Autowired
  private ProductRepository productRepository;

  public ProductListResponse findAll() {
    var entityList = productRepository.findAll();
    var data = mapper.toListResponse(entityList);

    return new ProductListResponse(data.size(), data);
  }

  public Optional<ProductResponse> findById(int productId) {
    var entity = productRepository.findById(productId);
    var response = entity.map(e -> mapper.toResponse(e));

    return response;
  }

  public Optional<ProductListResponse> findByCategoryId(int categoryId) {
    var entityList = productRepository.findByCategoryIdOrderByNameAsc(categoryId);
    var data = entityList.map(e -> mapper.toListResponse(e));

    return data.map(e -> new ProductListResponse(e.size(), e));
  }

  public ProductIdResponse save(ProductRequest request) {
    var entity = mapper.toEntity(request);
    var newEntity = productRepository.save(entity);

    return mapper.toIdResponse(newEntity);
  }

  public void delete(int productId) {
    this.findById(productId).ifPresent(product -> productRepository.deleteById(productId));
  }
}

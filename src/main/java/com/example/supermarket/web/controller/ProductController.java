package com.example.supermarket.web.controller;

import java.util.Collections;
import java.util.List;

import com.example.supermarket.domain.Product;
import com.example.supermarket.domain.dto.ProductGetAllRequest;
import com.example.supermarket.domain.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Products")
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    @ApiOperation(value = "Get all products")
    public ResponseEntity<List<Product>> getAll(ProductGetAllRequest request) {
        return ResponseEntity.ok(productService.getAll().orElse(Collections.emptyList()));
    }

    @GetMapping("/{productId}")
    @ApiOperation(value = "Get a product by its product id")
    public ResponseEntity<Product> getProduct(
            @ApiParam(value = "The id of the product", required = true, example = "7") @PathVariable int productId) {
        return ResponseEntity.of(productService.getProduct(productId));
    }

    @GetMapping("/categories/{categoryId}")
    @ApiOperation(value = "Get products by its category id")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId) {
        return ResponseEntity.of(productService.getByCategory(categoryId));
    }

    @PostMapping
    @ApiOperation(value = "Create a new product")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{productId}")
    @ApiOperation(value = "Delete a product by its product id")
    public ResponseEntity<Void> delete(@PathVariable int productId) {
        productService.delete(productId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

    }
}

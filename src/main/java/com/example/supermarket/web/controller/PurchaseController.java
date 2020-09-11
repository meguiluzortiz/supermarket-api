package com.example.supermarket.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Collections;
import java.util.List;

import com.example.supermarket.domain.Purchase;
import com.example.supermarket.domain.service.PurchaseService;

@Api(tags = "Purchases")
@RestController
@RequestMapping("/purchases")
public class PurchaseController {
  
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    @ApiOperation(value = "Get all purchases")
    public ResponseEntity<List<Purchase>> getAll() {
        return ResponseEntity.ok(purchaseService.getAll().orElse(Collections.emptyList()));
    }

    @GetMapping("/clients/{clientId}")
    @ApiOperation(value = "Get purchases by its client id")
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable String clientId) {
        return purchaseService.getByClient(clientId).map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ApiOperation(value = "Create a new purchase with all purchase items")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}

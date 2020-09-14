package com.example.supermarket.web.controller;

import com.example.supermarket.service.PurchaseService;
import com.example.supermarket.web.dto.PurchaseListResponse;
import com.example.supermarket.web.dto.PurchaseRequest;
import com.example.supermarket.web.dto.PurchaseResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Purchases")
@ApiResponses({ //
    @ApiResponse(code = 403, message = "Forbidden"), //
    @ApiResponse(code = 500, message = "Error") //
})
@RestController
@RequestMapping("/purchases")
public class PurchaseController {

  @Autowired
  private PurchaseService purchaseService;

  @GetMapping
  @ApiOperation(value = "Get all purchases")
  public ResponseEntity<PurchaseListResponse> findAll() {
    return ResponseEntity.ok(purchaseService.findAll());
  }

  @GetMapping("/clients/{clientId}")
  @ApiOperation(value = "Get purchases by its client id")
  @ApiResponses({ //
      @ApiResponse(code = 400, message = "Bad Request"), //
      @ApiResponse(code = 404, message = "Not Found") //
  })
  public ResponseEntity<PurchaseListResponse> findByClientId( //
      @ApiParam(value = "The id of the client", example = "4546221") //
      @PathVariable String clientId //
  ) {
    return ResponseEntity.of(purchaseService.findByClientId(clientId));
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  @ApiOperation(value = "Create a new purchase with all purchase items")
  @ApiResponses({ //
      @ApiResponse(code = 201, message = "Created"), //
      @ApiResponse(code = 400, message = "Bad Request") //
  })
  public ResponseEntity<PurchaseResponse> save(@RequestBody PurchaseRequest request) {
    return new ResponseEntity<>(purchaseService.save(request), HttpStatus.CREATED);
  }
}

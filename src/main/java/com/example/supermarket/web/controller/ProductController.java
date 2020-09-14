package com.example.supermarket.web.controller;

import com.example.supermarket.service.ProductService;
import com.example.supermarket.web.dto.ProductIdResponse;
import com.example.supermarket.web.dto.ProductListResponse;
import com.example.supermarket.web.dto.ProductRequest;
import com.example.supermarket.web.dto.ProductResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

@Api(tags = "Products")
@ApiResponses({ //
    @ApiResponse(code = 403, message = "Forbidden"), //
    @ApiResponse(code = 500, message = "Error") //
})
@RestController
@RequestMapping("/products")
public class ProductController {
  @Autowired
  private ProductService productService;

  @GetMapping
  @ApiOperation(value = "Get all products")
  public ResponseEntity<ProductListResponse> findAll() {
    return ResponseEntity.ok(productService.findAll());
  }

  @GetMapping("/{productId}")
  @ApiOperation(value = "Get a product by its product id")
  @ApiResponses({ //
      @ApiResponse(code = 400, message = "Bad Request"), //
  })
  public ResponseEntity<ProductResponse> findById( //
      @ApiParam(value = "The id of the product", example = "2") //
      @PathVariable int productId //
  ) {
    return ResponseEntity.of(productService.findById(productId));
  }

  @GetMapping("/categories/{categoryId}")
  @ApiOperation(value = "Get products by its category id")
  @ApiResponses({ //
      @ApiResponse(code = 400, message = "Bad Request"), //
      @ApiResponse(code = 404, message = "Not Found") //
  })
  public ResponseEntity<ProductListResponse> findByCategory(
      @ApiParam(value = "The id of the category", example = "1") //
      @PathVariable("categoryId") int categoryId //
  ) {
    return ResponseEntity.of(productService.findByCategoryId(categoryId));
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  @ApiOperation(value = "Create a new product")
  @ApiResponses({ //
      @ApiResponse(code = 201, message = "Created"), //
      @ApiResponse(code = 400, message = "Bad Request") //
  })
  public ResponseEntity<ProductIdResponse> save(@RequestBody ProductRequest request) {
    return new ResponseEntity<>(productService.save(request), HttpStatus.CREATED);
  }

  @DeleteMapping("/{productId}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  @ApiOperation(value = "Delete a product by its product id")
  @ApiResponses({ //
      @ApiResponse(code = 204, message = "No Content"), //
      @ApiResponse(code = 400, message = "Bad Request") //
  })
  public ResponseEntity<Void> delete( //
      @ApiParam(value = "The id of the product", example = "51") //
      @PathVariable int productId //
  ) {
    productService.delete(productId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);

  }
}

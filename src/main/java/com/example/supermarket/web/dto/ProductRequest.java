package com.example.supermarket.web.dto;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
  @ApiModelProperty(example = "Lechuga", position = 0)
  @NotEmpty
  private String name;
  
  @ApiModelProperty(example = "1", position = 1)
  @NotEmpty
  private int categoryId;
  
  @ApiModelProperty(example = "2000.0", position = 2)
  @NotEmpty
  private double price;
  
  @ApiModelProperty(example = "60", position = 3)
  @NotEmpty
  private int stock;
  
  @ApiModelProperty(example = "true", position = 4)
  @NotEmpty
  private boolean active;
}

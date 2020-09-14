package com.example.supermarket.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
  @ApiModelProperty(example = "2", position = 0)
  private int productId;
  @ApiModelProperty(example = "Mango", position = 1)
  private String name;
  @ApiModelProperty(example = "2100", position = 2)
  private double price;
  @ApiModelProperty(example = "250", position = 3)
  private int stock;
  @ApiModelProperty(example = "true", position = 4)
  private boolean active;
  @ApiModelProperty(example = "1", position = 5)
  private int categoryId;
  @ApiModelProperty(position = 6)
  private Category category;
}

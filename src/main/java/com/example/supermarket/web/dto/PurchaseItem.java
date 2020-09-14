package com.example.supermarket.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseItem {
  @ApiModelProperty(example = "1")
  private int productId;
  @ApiModelProperty(example = "10")
  private int quantity;
  @ApiModelProperty(example = "3000")
  private double total;
  @ApiModelProperty(example = "true")
  private boolean active;
}

package com.example.supermarket.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
  @ApiModelProperty(example = "1")
  private Integer categoryId;
  @ApiModelProperty(example = "Frutas y verduras")
  private String description;
  @ApiModelProperty(example = "true")
  private boolean active;
}
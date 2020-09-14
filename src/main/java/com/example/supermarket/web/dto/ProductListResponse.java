package com.example.supermarket.web.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductListResponse {

  @ApiModelProperty(example = "1", position = 0)
  private int total;

  @ApiModelProperty(position = 1)
  private List<ProductResponse> data;

}

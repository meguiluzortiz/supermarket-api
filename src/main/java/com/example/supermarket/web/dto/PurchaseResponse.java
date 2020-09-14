package com.example.supermarket.web.dto;

import java.time.LocalDateTime;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseResponse {
  
  @ApiModelProperty(example = "1", position = 0)
  private int purchaseId;
  @ApiModelProperty(example = "4546221", position = 1)
  private String clientId;
  @ApiModelProperty(example = "1992-10-08T17:30:00", position = 2)
  private LocalDateTime date;
  @ApiModelProperty(example = "CASH", position = 3)
  private String paymentMethod;
  @ApiModelProperty(example = "Comment", position = 4)
  private String comment;
  @ApiModelProperty(example = "PENDANT", position = 5)
  private String state;
  @ApiModelProperty(position = 6)
  private List<PurchaseItem> items;

}

package com.example.supermarket.web.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseRequest {
  @ApiModelProperty(example = "4546221", position = 0)
  @NotEmpty
  private String clientId;
  @ApiModelProperty(example = "1992-10-08T17:30:00", position = 1)
  @NotNull
  private LocalDateTime date;
  @ApiModelProperty(example = "E", position = 2)
  @NotNull
  private String paymentMethod;
  @ApiModelProperty(example = "Comment", position = 3)
  private String comment;
  @ApiModelProperty(example = "P", position = 4)
  @NotNull
  private String state;
  @NotEmpty
  @ApiModelProperty(position = 5)
  private List<PurchaseItem> items;
}

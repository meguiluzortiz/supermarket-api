package com.example.supermarket.web.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

   
  @NotEmpty
  @Size(min = 8, max = 15)
  @ApiModelProperty(example = "test")
  private String username;
  
  @NotEmpty
  @Size(min = 8, max = 30)
  @ApiModelProperty(example = "test")
  private String password;
  
}

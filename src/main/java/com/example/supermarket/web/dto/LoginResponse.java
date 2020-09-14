package com.example.supermarket.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginResponse {

  @ApiModelProperty(example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0IiwiaWF0IjoxNjAwMDUxMTI5LCJleHAiOjE2MDAwNTQ3Mjl9.MrJrRXZT7qcBLXr6HEvuslwm2CkG7pxl8Pa_ZRQ_JmE")
  private String jwt;

}

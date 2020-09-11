package com.example.supermarket.security.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {

  private String username;
  private String password;
  
}

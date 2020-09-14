package com.example.supermarket.web.controller;

import com.example.supermarket.util.JwtUtil;
import com.example.supermarket.web.dto.LoginRequest;
import com.example.supermarket.web.dto.LoginResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Security")
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserDetailsService platziUserDetailsService;

  @Autowired
  private JwtUtil jwtUtil;

  @PostMapping("/login")
  @ApiOperation(value = "Login user and responds with jwt token")
  public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
    try {
      authenticationManager
          .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
      UserDetails userDetails = platziUserDetailsService.loadUserByUsername(request.getUsername());
      String jwt = jwtUtil.generateToken(userDetails);

      return ResponseEntity.ok(new LoginResponse(jwt));
    } catch (BadCredentialsException e) {
      return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
  }

//  @PostMapping("/logout")
//  @ApiOperation(value = "Logout user", authorizations = { @Authorization(value = "JWT") })
//  public ResponseEntity<Void> logout() {
//    throw new RuntimeException("Not implemented method");
//  }
}

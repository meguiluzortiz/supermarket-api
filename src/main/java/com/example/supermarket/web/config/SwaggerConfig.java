package com.example.supermarket.web.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
  public static final String BASE_PACKAGE = "com.example.supermarket.web.controller";
  private static final List<String> DEFAULT_PRODUCES_CONSUMES = Arrays.asList("application/json");

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2) //
        .apiInfo(apiInfo()) //
        .tags(new Tag("Products", "Products endpoints"), new Tag("Purchases", "Purchases endpoints")) //
        .produces(new HashSet<>(DEFAULT_PRODUCES_CONSUMES)) //
        .consumes(new HashSet<>(DEFAULT_PRODUCES_CONSUMES)) //
        .select() //
        .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE)) //
        .paths(PathSelectors.any()) //
        .build();
  }

  private ApiInfo apiInfo() {
    var contact = new Contact("Manuel Eguiluz", "https://meguiluzortiz.github.io/", "eguiluz.manuel@gmail.com");
    var builder = new ApiInfoBuilder() //
        .title("Api Documentation") //
        .description("Supermarket api Documentation") //
        .version("1.0") //
        .termsOfServiceUrl("urn:tos") //
        .contact(contact) //
        .license("Apache 2.0") //
        .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0") //
        .extensions(new ArrayList<>());

    return builder.build();
  }

}

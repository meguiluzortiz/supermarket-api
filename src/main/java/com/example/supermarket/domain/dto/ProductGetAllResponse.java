package com.example.supermarket.domain.dto;

import lombok.Getter;

@Getter
class ProductGetAllResponseData {
    private int id;
    private String name;
    private int categoryId;
    private double price;
    private int stock;
    private boolean active;
}

@Getter
public class ProductGetAllResponse {
    private int total;
    private Object data;

}

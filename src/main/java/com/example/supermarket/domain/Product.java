package com.example.supermarket.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
	private int productId;
	private String name;
	private double price;
	private int stock;
	private boolean active;
	private int categoryId;
	private Category category;

}

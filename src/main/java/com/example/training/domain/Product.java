package com.example.training.domain;

import lombok.Data;

@Data
public class Product {

	public Product(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Product(Long id, String name, Integer price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Product() {

	}

	private Long id;
	private String name;
	private Integer price;
	private String image_path;
	private String description;
}

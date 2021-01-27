package com.example.training.web.domain.product;

import lombok.Data;

@Data
public class Product {

	/**
	 *
	 * DBから取得する時のキャスト用コンストラクタ
	 *
	 * @param productEntity
	 */
	public Product(ProductEntity productEntity) {
		this.id = productEntity.getId();
		this.name = productEntity.getName();
		this.price = productEntity.getPrice();
		this.imagePath = productEntity.getImagePath();
		this.description = productEntity.getDescription();
	}

	public Product(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Product(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Product() {

	}

	private int id;
	private String name;
	private int price;
	private String imagePath;
	private String description;

//	public String getImagePath() {
//		return this.imagePath;
//	}
//
//	public String getName() {
//		return this.name;
//	}
//
//	public Price getPrice() {
//		return this.price;
//	}

}

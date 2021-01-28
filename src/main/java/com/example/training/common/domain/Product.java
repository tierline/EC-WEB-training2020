package com.example.training.common.domain;

import com.example.training.common.domain.value.Price;
import com.example.training.common.entity.ProductEntity;

import lombok.Getter;

/**
 * 商品クラス
 */
@Getter
public class Product {
	/**
	 * 商品ID
	 */
	private int id;
	/**
	 * 商品名
	 */
	private String name;
	/**
	 * 商品価格
	 */
	private Price price;
	/**
	 * 商品画像PATH
	 */
	private String imagePath;
	/**
	 * 商品説明文
	 */
	private String description;

	/**
	 * DBから得るためのコンストラクタ
	 *
	 * @param productEntity
	 */
	public Product(ProductEntity productEntity) {
		this.id = productEntity.getId();
		this.name = productEntity.getName();
		this.price = new Price(productEntity.getPrice());
		this.imagePath = productEntity.getImagePath();
		this.description = productEntity.getDescription();
	}

	/**
	 * テスト用コンストラクタ
	 */
	public Product(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * テスト用コンストラクタ
	 */
	public Product(int id, String name, Price price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public Product() {

	}

	@Override
	public boolean equals(Object object) {
		return this.id == ((Product) object).id;
	}
}

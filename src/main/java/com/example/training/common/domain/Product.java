package com.example.training.common.domain;

import com.example.training.common.domain.value.Description;
import com.example.training.common.domain.value.ImagePath;
import com.example.training.common.domain.value.Price;
import com.example.training.common.domain.value.ProductName;
import com.example.training.common.domain.value.id.ProductId;
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
	private ProductId id;
	/**
	 * 商品名
	 */
	private ProductName name;
	/**
	 * 商品価格
	 */
	private Price price;
	/**
	 * 商品画像PATH
	 */
	private ImagePath imagePath;
	/**
	 * 商品説明文
	 */
	private Description description;

	/**
	 * DBから取得するためのコンストラクタ
	 *
	 * @param productEntity
	 */
	public Product(ProductEntity productEntity) {
		this.id = new ProductId(productEntity.getId());
		this.name = new ProductName(productEntity.getName());
		this.price = new Price(productEntity.getPrice());
		this.imagePath = new ImagePath(productEntity.getImagePath());
		this.description = new Description(productEntity.getDescription());
	}

	/**
	 * テスト用コンストラクタ
	 */
	public Product(ProductId id, ProductName name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * テスト用コンストラクタ
	 */
	public Product(ProductId id, ProductName name, Price price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public Product() {

	}

	/**
	 * 自身とオブジェクトが等しいか判定する
	 */
	@Override
	public boolean equals(Object object) {
		return this.id.getValue() == ((Product) object).id.getValue();
	}
}

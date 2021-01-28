package com.example.training.common.domain.value.address;

import lombok.Getter;
import lombok.Setter;

/**
 * 住所を表す値オブジェクト
 */
// setterなしで書くには
// TOREVIEW
@Getter
@Setter
public class Address {

	/**
	 * 住所の値
	 */
	private String value;
	/**
	 * 郵便番号
	 */
	private Postcode postcode;
	/**
	 * 都道府県
	 */
	private Prefecture prefecture;
	/**
	 * 市区町村
	 */
	private City city;
	/**
	 * 番地
	 */
	private Block block;

	/**
	 * 基本コンストラクタ
	 *
	 * @param postcode
	 * @param prefecture
	 * @param city
	 * @param block
	 */
	public Address(Postcode postcode, Prefecture prefecture, City city, Block block) {
		this.postcode = postcode;
		this.prefecture = prefecture;
		this.city = city;
		this.block = block;
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public Address() {

	}

	/**
	 * 住所の全文表示
	 *
	 * @return
	 */
	public String getValue() {
		this.value = "〒" + postcode.getValue() + " " + prefecture.getValue() + " " + city.getValue() + " "
				+ block.getValue();
		return this.value;
	}

}

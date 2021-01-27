package com.example.training.web.domain.member.address;

import lombok.Getter;

@Getter
public class Address {

	private String value;
	/*
	 * 郵便番号
	 */
	private Postcode postcode;
	/*
	 * 都道府県
	 */
	private Prefecture prefecture;
	/*
	 * 市区町村
	 */
	private City city;
	/*
	 * 番地等
	 */
	private Block block;

	public Address(Postcode postcode, Prefecture prefecture, City city, Block block) {
		this.postcode = postcode;
		this.prefecture = prefecture;
		this.city = city;
		this.block = block;
	}

	public Address() {

	}

	/*
	 * 郵便番号から住所、すべてを繋げて返す
	 */
	public String getValue() {
		this.value = "〒" + postcode.getValue() + " " + prefecture.getValue() + " " + city.getValue() + " "
				+ block.getValue();
		return this.value;
	}

}

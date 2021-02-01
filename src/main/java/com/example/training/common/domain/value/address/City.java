package com.example.training.common.domain.value.address;

import com.example.training.common.domain.value.Assertion;

import lombok.Getter;

/**
 * 市区町村を表す値オブジェクト
 */
public class City {
	/*
	 * 最大入力文字数 最低入力文字数
	 */
	private final Integer MAX = 50;
	private final Integer MIN = 1;

	/**
	 * 市区町村の値
	 */
	@Getter
	private String value;

	/**
	 * 基本コンストラクタ
	 */
	public City(String value) {
		Assertion.length(value, MIN, MAX);
		this.value = value;
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public City() {

	}
}

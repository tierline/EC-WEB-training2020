package com.example.training.common.domain.value.address;

import lombok.Getter;
import lombok.Setter;

/**
 * 市区町村を表す値オブジェクト
 */
@Getter
@Setter
public class City {
	/**
	 * 市区町村の値
	 */
	private String value;

	/**
	 * 基本コンストラクタ
	 *
	 * @param value
	 */
	public City(String value) {
		this.value = value;
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public City() {

	}
}

package com.example.training.common.domain.value.address;

import com.example.training.common.domain.value.Assertion;

/**
 * 都道府県を表す値オブジェクト
 */
public class Prefecture {

	private final Integer MIN = 3;
	private final Integer MAX = 4;
	private String value;

	/**
	 * 基本コンストラクタ
	 */
	public Prefecture(String value) {
		Assertion.isNull(value);
		Assertion.length(value, MIN, MAX);
		this.value = value;
	}

	public Prefecture() {

	}

	public String getValue() {
		return this.value;
	}
}
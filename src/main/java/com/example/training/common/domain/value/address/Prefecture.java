package com.example.training.common.domain.value.address;

import com.example.training.common.domain.value.Assertion;

import lombok.Getter;

/**
 * 都道府県を表す値オブジェクト
 */
public class Prefecture {

	private final Integer MIN = 3;
	private final Integer MAX = 4;
	@Getter
	private String value;

	/**
	 * 基本コンストラクタ
	 */
	public Prefecture(String value) {
		Assertion.isNull(value);
		Assertion.length(value, MIN, MAX);
		this.value = value;
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public Prefecture() {

	}

}

package com.example.training.common.domain.value.address;

import com.example.training.common.domain.value.Assertion;

import lombok.Getter;

/**
 * 都道府県を表す値オブジェクト
 */
public class Prefecture {

	/**
	 * 都道府県名の最小値
	 */
	private final Integer MIN = 3;
	/**
	 * 都道府県名の最大値
	 */
	private final Integer MAX = 4;

	/**
	 * 都道府県の値
	 */
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

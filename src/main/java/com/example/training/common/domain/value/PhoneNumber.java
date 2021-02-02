package com.example.training.common.domain.value;

import lombok.Getter;

/**
 * 電話番号を表す値オブジェクト
 */

public class PhoneNumber {

	/**
	 * 電話番号の最小値
	 */
	private final Integer MIN = 10;
	/**
	 * 電話番号の最大値
	 */
	private final Integer MAX = 11;
	/**
	 * 電話番号の値
	 */
	@Getter
	private String value;

	/**
	 * 基本コンストラクタ
	 */
	public PhoneNumber(String value) {
		Assertion.isNull(value);
		Assertion.length(value, MIN, MAX);
		this.value = value;
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public PhoneNumber() {

	}

}

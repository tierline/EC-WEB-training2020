package com.example.training.common.domain.value;

import lombok.Getter;

/**
 * Eメールを表す値オブジェクト
 */
public class Email {

	/**
	 * Eメールの値
	 */
	@Getter
	private String value;

	/**
	 * Eメールの長さの最小値
	 */
	private final Integer MIN = 3;

	/**
	 * Eメールの長さの最大値
	 */
	private final Integer MAX = 256;

	/**
	 * 基本コンストラクタ
	 *
	 * @param value
	 */
	public Email(String value) {
		Assertion.isNull(value);
		Assertion.length(value, MIN, MAX);

		this.value = value;
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public Email() {

	}

}

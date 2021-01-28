package com.example.training.common.domain.value;

import lombok.Getter;

/**
 * Eメールを表す値オブジェクト
 */
public class Email {

	/**
	 * Eメールの値 TODO: value は final で。
	 */
	@Getter
	private String value;

	/**
	 * 基本コンストラクタ
	 *
	 * @param value
	 */
	public Email(String value) {
		if (value == null) {
			throw new NullPointerException();
		}
		this.value = value;
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public Email() {

	}

}

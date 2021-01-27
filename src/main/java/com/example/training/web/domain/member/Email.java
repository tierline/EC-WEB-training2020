package com.example.training.web.domain.member;

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

package com.example.training.common.domain.value.address;

import lombok.Getter;
import lombok.Setter;

/**
 * 郵便番号を表す値オブジェクト
 */
@Getter
@Setter
public class Postcode {
	/**
	 * 郵便番号の値
	 */
	private String value;

	/**
	 * 基本コンストラクタ
	 *
	 * @param value
	 */
	public Postcode(String value) {
		this.value = value;
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public Postcode() {
	}
}

package com.example.training.common.domain.value;

import lombok.Getter;
import lombok.Setter;

/**
 * 電話番号を表す値オブジェクト
 */
@Getter
@Setter
public class PhoneNumber {

	/**
	 * 電話番号の値
	 */
	private String value;

	/**
	 * 基本コンストラクタ
	 */
	public PhoneNumber(String value) {
		this.value = value;
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public PhoneNumber() {

	}

}

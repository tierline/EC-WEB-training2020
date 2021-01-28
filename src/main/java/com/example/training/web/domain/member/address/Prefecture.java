package com.example.training.web.domain.member.address;

import lombok.Getter;
import lombok.Setter;

/**
 * 都道府県を表す値オブジェクト
 */
@Getter
@Setter
public class Prefecture {

	/**
	 * 都道府県の値
	 */
	private String value;

	/**
	 * 基本コンストラクタ
	 *
	 * @param value
	 */
	public Prefecture(String value) {
		this.value = value;
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public Prefecture() {

	}
}

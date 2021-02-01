package com.example.training.common.domain.value;

import lombok.Getter;

/**
 * 権限を表す値オブジェクト
 */
public class Role {
	/**
	 * 権限の値
	 */
	@Getter
	private String value;

	/**
	 * 基本コンストラクタ
	 *
	 * @param value
	 */
	public Role(String value) {
		Assertion.isNull(value);
		this.value = value;
	}

}

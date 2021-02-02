package com.example.training.common.domain.value;

import lombok.Getter;

/**
 * パスワード（ハッシュ値）を表す値オブジェクト
 */
public class DigestPassword {

	/**
	 * パスワードの値
	 */
	@Getter
	private String value;

	/**
	 * 基本コンストラクタ。平文のパスワードをハッシュ値に変換する。
	 *
	 * @param digestPassword 平文のパスワード
	 */
	public DigestPassword(String value) {
		Assertion.isNull(value);
		this.value = value;
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public DigestPassword() {
	}

}

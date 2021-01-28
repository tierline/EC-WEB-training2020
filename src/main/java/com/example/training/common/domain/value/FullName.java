package com.example.training.common.domain.value;

import lombok.Getter;

/**
 * 会員の氏名を表す値オブジェクト
 */
@Getter
public class FullName {
	/**
	 * 姓
	 */
	private Name lastName;

	/**
	 * 名
	 */
	private Name firstName;

	/**
	 * 基本コンストラクタ
	 */
	public FullName(Name lastName, Name firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public FullName() {

	}

	/**
	 * 氏名を取得する
	 *
	 * @return 氏名
	 */
	public String getValue() {
		return this.lastName.getValue() + this.firstName.getValue();
	}
}

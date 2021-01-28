package com.example.training.web.domain.member;

import lombok.Getter;

/**
 * 会員の氏名を表す値オブジェクト
 */
@Getter
public class FullName {
	/**
	 * 姓
	 */
	private String lastName;

	/**
	 * 名
	 */
	private String firstName;

	/**
	 * 姓・名の最大値
	 */
	private final int MAX = 16;

	/**
	 * 姓・名の最小値
	 */
	private final int MIN = 1;

	/**
	 * 基本コンストラクタ
	 */
	public FullName(String lastName, String firstName) {
		if (lastName == null) {
			throw new NullPointerException("姓が入力されていません");
		}
		if (lastName.length() < MIN || lastName.length() > MAX) {
			throw new IllegalArgumentException("姓が字数制限を満たしていません");
		}
		if (firstName == null) {
			throw new NullPointerException("名が入力されていません");
		}
		if (firstName.length() < MIN || firstName.length() > MAX) {
			throw new IllegalArgumentException("名が字数制限を満たしていません");
		}
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
		return this.lastName + this.firstName;
	}
}

package com.example.training.common.domain.value.address;

import lombok.Getter;

/**
 * 郵便番号を表す値オブジェクト
 */
public class Postcode {
// TODO
	/*
	 * ハイフンなしの郵便番号の長さ
	 */
	private final Integer LENGTH = 7;
	@Getter
	private String value;

	/*
	 * 郵便番号の長さ、使用されている文字の確認 OKなら作成する
	 */
	public Postcode(String value) {
		if (value.length() != LENGTH) {
			throw new IllegalArgumentException("郵便番号はハイフンなしの7桁のみです");
		}
//		if (!canRegexp(value)) {
//			throw new IllegalArgumentException("半角数字のみです");
//		}
		this.value = value;
	}

	public Postcode() {
	}

	/*
	 * 半角数字のみかの確認
	 */
	// private Boolean canRegexp(String value) {
	// String regexp = "[0-9]";
	// return value.matches(regexp);
	// }
}

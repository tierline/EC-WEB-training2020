package com.example.training.common.domain.value;

import lombok.Getter;

/**
 * 画像PATHを表す値オブジェクト
 */
public class ImagePath {

	/**
	 * 画像PATHの値
	 */
	@Getter
	public String value;

	/**
	 * 基本コンストラクタ
	 *
	 * @param value
	 */
	public ImagePath(String value) {
		Assertion.isNull(value);
		this.value = value;
	}

	/*
	 * 半角英数字とハイフン、アンダーバー、ドット
	 */
	private String regex() {
		return "[0-9a-zA-Z\\-\\_\\.]+";
	}

}

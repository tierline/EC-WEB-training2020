package com.example.training.web.domain.member.address;

public class City {
	/*
	 * 最大入力文字数
	 */
	private final Integer MAX = 50;
	private final Integer MIN = 1;
	private String value;

	public City(String value) {
		if (value.length() >= MAX) {
			throw new IllegalArgumentException("最大入力文字数は50文字までです");
		}
		if (value.length() < MIN) {
			throw new IllegalArgumentException("最低入力文字数は1文字です");
		}
		this.value = value;
	}

	public City() {

	}

	public String getValue() {
		return this.value;
	}
}

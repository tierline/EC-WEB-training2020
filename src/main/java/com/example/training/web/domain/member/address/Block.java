package com.example.training.web.domain.member.address;

public class Block {

	private final Integer MAX = 130;
	private String value;

	public Block(String value) {
		if (value.length() > MAX) {
			throw new IllegalArgumentException("最大文字数は130文字です");
		}
		this.value = value;
	}

	public Block() {

	}

	public String getValue() {
		return this.value;
	}
}

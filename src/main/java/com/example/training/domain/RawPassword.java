package com.example.training.domain;

import lombok.Getter;

public class RawPassword {
	@Getter
	private String value;

	public RawPassword(String value) {
		if (value.length() > 16) {
			throw new IllegalArgumentException("文字数が多すぎます");
		}
		this.value = value;
	}
}

package com.example.training.common.domain.value;

import lombok.Getter;

// TODO このクラスは削除しても構わない？
public class RawPassword {
	@Getter
	private String value;

	public RawPassword(String value) {
		if (value == null) {
			throw new NullPointerException();
		}
		if (value.length() > 16) {
			throw new IllegalArgumentException("文字数が多すぎます");
		}
		this.value = value;
	}
}

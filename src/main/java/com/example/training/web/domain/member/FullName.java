package com.example.training.web.domain.member;

import lombok.Getter;

/**
 *
 */
@Getter
public class FullName {
	private String lastName;

	private String firstName;

	private final int MAX = 16;

	private final int MIN = 1;

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

	public FullName() {

	}

	// 名前の全ての値を取る場合は？
	// クライアントが何かによって変わる。タイムリーフの場合は、getter的にStringで返してもよい
	public String getValue() {
		return this.lastName + this.firstName;
	}
}

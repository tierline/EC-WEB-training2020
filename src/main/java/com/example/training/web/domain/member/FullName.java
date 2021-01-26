package com.example.training.web.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FullName {
	private String lastName;

	// C: これでもいけるか？
	private String firstName;

	private final int MAX = 5;

	private final int MIN = 1;

	public FullName(String lastName, String firstName) {
		if (lastName == null) {
			throw new IllegalArgumentException("値が入力");
		}
		if (lastName.length() < MIN || lastName.length() > MAX) {
			throw new IllegalArgumentException("値が入力");
		}
		if (firstName == null) {
			throw new IllegalArgumentException("値が入力");
		}
		if (firstName.length() < MIN || firstName.length() > MAX) {
			throw new IllegalArgumentException("値が入力");
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

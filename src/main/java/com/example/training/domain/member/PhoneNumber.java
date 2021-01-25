package com.example.training.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneNumber {
//ここにはバリデーション書かない
	// Form側に移動する

	private String value;

	public PhoneNumber(String value) {
		this.value = value;
	}

	public PhoneNumber() {

	}

}

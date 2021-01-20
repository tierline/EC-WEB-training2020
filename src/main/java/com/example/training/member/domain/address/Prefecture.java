package com.example.training.member.domain.address;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;

@Getter
public class Prefecture {
	@NotEmpty
	@Size(min = 2, max = 4, message = "入力できる文字数を超過しています。")
	private String prefecture;

	public Prefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public Prefecture() {

	}
}

package com.example.training.web.domain.address;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Prefecture {
	@NotEmpty
	@Size(min = 2, max = 4, message = "入力できる文字数を超過しています。")
	private String value;

	public Prefecture(String value) {
		this.value = value;
	}

	public Prefecture() {

	}
}

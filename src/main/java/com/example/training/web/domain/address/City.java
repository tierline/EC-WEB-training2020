package com.example.training.web.domain.address;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City {
	@Size(min = 1, max = 20, message = "入力できる文字数を超過しています。")
	private String value;

	public City(String value) {
		this.value = value;
	}

	public City() {

	}
}

package com.example.training.member.domain.address;

import javax.validation.constraints.Size;

import lombok.Getter;

@Getter
public class City {
	@Size(min = 1, max = 20, message = "入力できる文字数を超過しています。")
	private String city;

	public City(String city) {
		this.city = city;
	}

	public City() {

	}
}

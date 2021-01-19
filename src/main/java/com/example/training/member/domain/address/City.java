package com.example.training.member.domain.address;

import javax.validation.constraints.Size;

public class City {
	@Size(min = 1, max = 20)
	private String city;

	public City(String city) {
		this.city = city;
	}
}

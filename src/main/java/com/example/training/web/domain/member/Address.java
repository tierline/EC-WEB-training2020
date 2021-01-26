package com.example.training.web.domain.member;

import javax.validation.Valid;

import com.example.training.web.domain.address.Block;
import com.example.training.web.domain.address.City;
import com.example.training.web.domain.address.Postcode;
import com.example.training.web.domain.address.Prefecture;

import lombok.Getter;

@Getter
public class Address {

	private String value;
	@Valid
	private Postcode postcode;
	@Valid
	private Prefecture prefecture;
	@Valid
	private City city;
	@Valid
	private Block block;

	public Address(Postcode postcode, Prefecture prefecture, City city, Block block) {
		this.postcode = postcode;
		this.prefecture = prefecture;
		this.city = city;
		this.block = block;
	}

	public Address() {

	}

	public String getValue() {
		this.value = "〒" + postcode.getValue() + " " + prefecture.getValue() + " " + city.getValue() + " "
				+ block.getValue();
		return this.value;
	}

}

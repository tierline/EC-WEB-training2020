package com.example.training.member.domain;

import com.example.training.member.domain.address.Block;
import com.example.training.member.domain.address.City;
import com.example.training.member.domain.address.Postcode;
import com.example.training.member.domain.address.Prefecture;

import lombok.Getter;
import lombok.Setter;

//setterなしで書くには
//TOREVIEW
@Getter
@Setter
public class Address {
	private Postcode postcode;
	private Prefecture prefecture;
	private City city;
	private Block block;

	public Address(Postcode postcode, Prefecture prefecture, City city, Block block) {
		this.postcode = postcode;
		this.prefecture = prefecture;
		this.city = city;
		this.block = block;
	}

	public Address() {

	}
}

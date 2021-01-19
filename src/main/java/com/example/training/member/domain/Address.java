package com.example.training.member.domain;

import lombok.Getter;

@Getter
public class Address {
	private String postCode;
	private String prefecture;
	private String city;
	private String block;

	public Address(String postCode, String prefecture, String city, String block) {
		this.postCode = postCode;
		this.prefecture = prefecture;
		this.city = city;
		this.block = block;
	}

//	public PostCode getPostCode() {
//		return this.postCode;
//	}
//
//	public Prefecture getPrefecture() {
//		return this.prefecture;
//	}
//
//	public City getCity() {
//		return this.city;
//	}
//
//	public String getBlock() {
//		return this.block;
//	}
}

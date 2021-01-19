package com.example.training.member.domain.address;

public class Address {
	private PostCode postCode;
	private Prefecture prefecture;
	private City city;
	private String block;

	public Address(PostCode postCode, Prefecture prefecture, City city, String block) {
		this.postCode = postCode;
		this.prefecture = prefecture;
		this.city = city;
		this.block = block;
	}

	public PostCode getPostCode() {
		return this.postCode;
	}

	public Prefecture getPrefecture() {
		return this.prefecture;
	}

	public City getCity() {
		return this.city;
	}

	public String getBlock() {
		return this.block;
	}
}

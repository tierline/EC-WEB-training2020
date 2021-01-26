package com.example.training.web.domain;

import lombok.Data;

@Data
public class MemberEntity {
	private long memberId;
	private String password;
	private String email;
	private String phoneNumber;
	private String lastName;
	private String firstName;
	private String postcode;
	private String prefecture;
	private String city;
	private String block;
	private String status;
	private String lastUpdatedBy;

	public String getFullName() {
		return this.lastName + this.firstName;
	}

	public String getFullAddress() {
		return "〒" + this.postcode + " " + this.prefecture + " " + this.city + " " + this.block;
	}

}

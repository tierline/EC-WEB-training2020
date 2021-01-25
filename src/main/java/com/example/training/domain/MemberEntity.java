package com.example.training.domain;

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

	public Long getMemberId() {
		return this.memberId;
	}

	public String getFullName() {
		return this.lastName + this.firstName;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public String getFullAddress() {
		return "〒" + this.postcode + " " + this.prefecture + " " + this.city + " " + this.block;
	}

}

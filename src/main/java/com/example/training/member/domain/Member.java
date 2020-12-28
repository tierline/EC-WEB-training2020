package com.example.training.member.domain;

import lombok.Data;

@Data
public class Member {
	public static final String SESSION_NAME = "MEMBER";
	private int id;
	private String email;
	private String password;
	private String lastName;
	private String firstName;
	private String postcode;
	private String prefecture;
	private String city;
	private String block;
	private String phoneNumber;
	private String lastUpdatedBy;
	private String status;
	private String roles = "ROLE_USER";

	public Member() {

	}

	public Member(int id, String email, String password, String lastName, String firstName, String postcode,
			String city, String block, String phoneNumber, String prefecture, String roles, String lastUpdatedBy,
			String status) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.postcode = postcode;
		this.prefecture = prefecture;
		this.city = city;
		this.block = block;
		this.phoneNumber = phoneNumber;
		this.lastUpdatedBy = lastUpdatedBy;
		this.status = status;
		this.roles = roles;
	}

}

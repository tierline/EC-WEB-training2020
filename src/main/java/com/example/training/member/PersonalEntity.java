package com.example.training.member;

import lombok.Data;

@Data
public class PersonalEntity {
	private long id;
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
	private String roles = "ROLE_USER";
}

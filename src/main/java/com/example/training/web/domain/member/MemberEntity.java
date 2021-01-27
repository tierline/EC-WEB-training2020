package com.example.training.web.domain.member;

import lombok.Data;

@Data
public class MemberEntity {
	private long memberId;
	private String email;
	private String password;
	private String lastName;
	private String firstName;
	private String phoneNumber;
	private String postcode;
	private String prefecture;
	private String city;
	private String block;
	private String status;
	private String lastUpdatedBy;
	private String roles = "ROLE_USER";

}

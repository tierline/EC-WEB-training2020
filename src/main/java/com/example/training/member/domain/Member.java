package com.example.training.member.domain;

import lombok.Data;

@Data
public class Member {
	public static final String SESSION_NAME = "MEMBER";

	// 基本情報
	private int id;
	private String password;
	// 連絡先
	private String email;
	private String phoneNumber;
	// 名前
	private String lastName;
	private String firstName;
	// 住所
	private String postcode;
	private String prefecture;
	private String city;
	private String block;
	// その他
	private String lastUpdatedBy;
	private String status;
	private String roles = "ROLE_USER";

	public Member(int id, String password, String email, String phone_number, String last_name, String first_name,
			String postcode, String prefecture, String city, String block, String last_updated_by, String status) {
		this.id = id;
		this.email = email;
		this.phoneNumber = phone_number;
		this.lastName = last_name;
		this.firstName = first_name;
		this.postcode = postcode;
		this.prefecture = prefecture;
		this.city = city;
		this.block = block;
	}

	public Member(MemberApplicateForm memberApplicateForm) {
		this.password = memberApplicateForm.getPassword();
		this.email = memberApplicateForm.getEmail();
		this.lastUpdatedBy = "none";
		this.status = "unapproved";
	}

}

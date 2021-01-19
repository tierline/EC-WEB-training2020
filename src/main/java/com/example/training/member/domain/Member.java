package com.example.training.member.domain;

import com.example.training.member.domain.form.MemberApplicationForm;

import lombok.Data;

@Data
public class Member {
	public static final String SESSION_NAME = "MEMBER";

	// 基本情報
	// MemberIdクラス
	private int id;
	// Passwordクラス
	private String password;
	// 連絡先
	// Emailクラス
	private String email;
	// PhoneNumberクラス
	private String phoneNumber;
	// 名前 //Nameクラス
	// private FullName fullName;
	private String lastName;
	private String firstName;
	// 住所
	// Addressクラス
	private String postcode;
	private String prefecture;
	private String city;
	private String block;
	// その他
	private String lastUpdatedBy;
	private String status;
	private String roles = "ROLE_USER";

	public Member(MemberApplicationForm memberApplicationForm, String passwordDigest) {
		this.password = passwordDigest;
		this.email = memberApplicationForm.getEmail();
		this.lastUpdatedBy = "none";
		this.status = "unapproved";
	}

	// public Member(String email, String lastName, String firstName) {
	// this.fullName = new FullName(lastName, firstName);
	// this.email = email;
	// }

	public Member() {
	}

}

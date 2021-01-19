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
	private FullName fullName;
//	private String lastName;
//	private String firstName;
	// 住所
	// Addressクラス
	private Address address;
//	private String postcode;
//	private String prefecture;
//	private String city;
//	private String block;
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

	// 元の実装
//	public Member(String lastName, String firstName, String email, String postcode, String prefecture, String city,
//			String block, String phoneNumber, String status) {
//		this.lastName = lastName;
//		this.firstName = firstName;
//		this.email = email;
//		this.postcode = postcode;
//		this.prefecture = prefecture;
//		this.city = city;
//		this.block = block;
//		this.phoneNumber = phoneNumber;
//		this.status = status;
//	}

	public Member(FullName fullName, String email, Address address, String phoneNumber, String status) {
		this.fullName = fullName;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}

//	public String getFullName() {
//		return this.lastName + this.firstName;
//	}

//	public Member(String email, String lastName, String firstName) {
//		this.fullName = new FullName(lastName, firstName);
//		this.email = email;
//	}

	public Member() {
	}

}

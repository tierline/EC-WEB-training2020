package com.example.training.member.domain;

import com.example.training.member.MemberEntity;
import com.example.training.member.domain.address.Block;
import com.example.training.member.domain.address.City;
import com.example.training.member.domain.address.Postcode;
import com.example.training.member.domain.address.Prefecture;
import com.example.training.member.domain.form.MemberApplicationForm;

import lombok.Data;

@Data
public class Member {
	public static final String SESSION_NAME = "MEMBER";
	// 基本情報
	private MemberId id;
	private String password;
	private FullName fullName;
	private Address address;
	// Passwordクラス
	// Emailクラス
	private String email;
	private PhoneNumber phoneNumber;
	private String lastUpdatedBy;
	private String status;
	private String roles = "ROLE_USER";

	public Member(MemberApplicationForm memberApplicationForm, String passwordDigest) {
		this.password = passwordDigest;
		this.email = memberApplicationForm.getEmail();
		this.lastUpdatedBy = "none";
		this.status = "unapproved";
	}

	public Member(MemberId id, String email, FullName fullName, Address address, PhoneNumber phoneNumber,
			String status) {
		this.id = id;
		this.email = email;
		this.fullName = fullName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}

	public Member(MemberEntity entity) {
		this.id = new MemberId(entity.getMemberId());
		this.password = entity.getPassword();
		this.email = entity.getEmail();
		this.fullName = new FullName(entity.getLastName(), entity.getFirstName());
		this.address = new Address(new Postcode(entity.getPostcode()), new Prefecture(entity.getPrefecture()),
				new City(entity.getCity()), new Block(entity.getBlock()));
		this.phoneNumber = new PhoneNumber(entity.getPhoneNumber());
		this.status = entity.getStatus();
		this.lastUpdatedBy = entity.getLastUpdatedBy();
	}

	public Member() {
	}

}

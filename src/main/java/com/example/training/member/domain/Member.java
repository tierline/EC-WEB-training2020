package com.example.training.member.domain;

import com.example.training.member.MemberEntity;
import com.example.training.member.domain.address.Block;
import com.example.training.member.domain.address.City;
import com.example.training.member.domain.address.Postcode;
import com.example.training.member.domain.address.Prefecture;

import lombok.Getter;

@Getter
public class Member {
	public static final String SESSION_NAME = "MEMBER";
	// 基本情報
	private MemberId id;
	private String digestPassword; // fix
	private FullName fullName;
	private Address address;
	// Passwordクラス
	private String email;
	private PhoneNumber phoneNumber;
	private String lastUpdatedBy; // fix
	private String status; // fix
	private String roles = "ROLE_USER"; // fix: Role自作

	public Member(MemberApplicationForm memberApplicationForm, String passwordDigest) {
		this.digestPassword = passwordDigest;
		// this.email = new Email(memberApplicationForm.getEmail()); fix
		this.email = memberApplicationForm.getEmail();
		this.lastUpdatedBy = "none";
		this.status = "unapproved";
	}

	public Member(MemberId id, String email, FullName fullName, Address address, PhoneNumber phoneNumber, String status) {
		this.id = id;
		// this.email = new Email(email); // fix
		this.email = email;
		this.fullName = fullName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}

	public Member(MemberEntity entity) {
		this.id = new MemberId(entity.getMemberId());
		// this.password = new DigestPassword(entity.getPassword());
		this.digestPassword = entity.getPassword();
		// this.email = new Email(entity.getEmail());
		this.email = entity.getEmail();
		this.fullName = new FullName(entity.getLastName(), entity.getFirstName());
		this.address = new Address(new Postcode(entity.getPostcode()), new Prefecture(entity.getPrefecture()),
				new City(entity.getCity()), new Block(entity.getBlock()));
		this.phoneNumber = new PhoneNumber(entity.getPhoneNumber());
		// fix new して
		this.status = entity.getStatus();
		this.lastUpdatedBy = entity.getLastUpdatedBy();
		// this.status = new MemberStatus(entity.getStatus());
		// this.lastUpdatedBy = new Admin(entity.getLastUpdatedBy());
	}

	public Member() {

	}

}

package com.example.training.member.domain;

import javax.management.relation.Role;

import com.example.training.admin.domain.Admin;
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
	private DigestPassword digestPassword;
	private FullName fullName;
	private Address address;
	// Passwordクラス
	private Email email;
	private PhoneNumber phoneNumber;
	private Admin lastUpdatedBy;
	private MemberStatus status;
	private Role roles = "ROLE_USER"; // fix: Role自作

	public Member(MemberApplicationForm memberApplicationForm, String passwordDigest) {
		this.password = passwordDigest;
		this.email = memberApplicationForm.getEmail();
		this.lastUpdatedBy = "none";
		this.status = "unapproved";
	}

	public Member(MemberId id, String email, FullName fullName, Address address, PhoneNumber phoneNumber, String status) {
		this.id = id;
		this.email = email;
		this.fullName = fullName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}

	public Member(MemberEntity entity) {
		this.id = new MemberId(entity.getMemberId());
		this.password = new DigestPassword(entity.getPassword());
		this.email = new Email(entity.getEmail());
		this.fullName = new FullName(entity.getLastName(), entity.getFirstName());
		this.address = new Address(new Postcode(entity.getPostcode()), new Prefecture(entity.getPrefecture()),
				new City(entity.getCity()), new Block(entity.getBlock()));
		this.phoneNumber = new PhoneNumber(entity.getPhoneNumber());
		// fix new して
		this.status = new MemberStatus(entity.getStatus());
		this.lastUpdatedBy = new Admin(entity.getLastUpdatedBy());
	}

	public Member() {

	}

}

package com.example.training.web.domain.member;

import com.example.training.web.domain.member.address.Address;
import com.example.training.web.domain.member.address.Block;
import com.example.training.web.domain.member.address.City;
import com.example.training.web.domain.member.address.Postcode;
import com.example.training.web.domain.member.address.Prefecture;

import lombok.Getter;

@Getter
public class Member {
	public static final String SESSION_NAME = "MEMBER";
	// 基本情報
	private MemberId memberId;
	private String digestPassword; // fix
	private FullName fullName;
	private Address address;
	// Passwordクラス
	private Email email;
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

	public Member(MemberId id, Email email, FullName fullName, Address address, PhoneNumber phoneNumber,
			String status) {
		this.memberId = id;
		// this.email = new Email(email); // fix
		this.email = email;
		this.fullName = fullName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}

	public Member(MemberEntity entity) {
		this.memberId = new MemberId(entity.getMemberId());
//		 this.password = new DigestPassword(entity.getPassword());
		this.digestPassword = entity.getPassword();
		this.email = new Email(entity.getEmail());
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

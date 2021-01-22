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
	private DigestPassword password;
	private FullName fullName;
	private Address address;
	// Passwordクラス
	private Email email;
	private PhoneNumber phoneNumber;
	private Admin lastUpdatedBy;
	private MemberStatus status;
	private Role roles = "ROLE_USER";

//status を列挙型に
	/*
	 * 新規登録処理 なんのときに使うか書く
	 */
	public Member(Email email, DigestPassword passwordDigest) {
		this.password = passwordDigest;
		this.email = email;
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

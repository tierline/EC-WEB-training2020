package com.example.training.member.domain;

import com.example.training.admin.domain.Admin;
import com.example.training.domain.Address;
import com.example.training.domain.Email;
import com.example.training.domain.MemberId;
import com.example.training.domain.MemberStatus;
import com.example.training.domain.PhoneNumber;
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
	private Email email;
	private PhoneNumber phoneNumber;
	private Admin lastUpdatedBy;
	private MemberStatus status;
	private Role roles;

//status を列挙型に
	/*
	 * 新規登録処理 なんのときに使うか書く
	 */

//	public Member(Email email, DigestPassword passwordDigest) {

	public Member(Email email, DigestPassword password) {

		this.password = password;
		this.email = email;
		this.status = MemberStatus.UNAPPROVED;
	}

	public Member(MemberId id, Email email, FullName fullName, Address address, PhoneNumber phoneNumber,
			MemberStatus status) {
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
		this.status = MemberStatus.UNAPPROVED;
//		this.lastUpdatedBy = new Admin(entity.getLastUpdatedBy());
	}

	public Member() {

	}

}

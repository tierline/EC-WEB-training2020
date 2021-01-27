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
	private DigestPassword digestPassword; // fix
	private FullName fullName;
	private Address address;
	private Email email;
	private PhoneNumber phoneNumber;
	private String lastUpdatedBy; // fix
	private String status = "unapproved"; // fix
	private Role roles; // fix: Role自作

	/*
	 * 新規会員登録時のメンバー作成
	 */
	public Member(Email email, DigestPassword digestPassword) {
		this.digestPassword = digestPassword;
		// this.email = new Email(memberApplicationForm.getEmail()); fix
		this.email = email;
		this.lastUpdatedBy = "none";
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

	/*
	 * DBから取得した値で既存のメンバー作成
	 */
	public Member(MemberEntity entity) {
		this.memberId = new MemberId(entity.getMemberId());
		this.digestPassword = new DigestPassword(entity.getPassword());
		this.email = new Email(entity.getEmail());
		this.fullName = new FullName(entity.getLastName(), entity.getFirstName());
		this.address = new Address(new Postcode(entity.getPostcode()), new Prefecture(entity.getPrefecture()),
				new City(entity.getCity()), new Block(entity.getBlock()));
		this.phoneNumber = new PhoneNumber(entity.getPhoneNumber());
		// fix new して
		this.status = entity.getStatus();
		this.lastUpdatedBy = entity.getLastUpdatedAdmin();
		// this.lastUpdatedBy = new Admin(entity.getLastUpdatedBy());
	}

	public Member() {

	}

	/*
	 * ログイン認証時に使う
	 */
	public String getDigestPassword() {
		return this.digestPassword.getValue();
	}

	/*
	 * ログイン認証時に使う
	 */
	public String getEmail() {
		return this.email.getValue();
	}

}

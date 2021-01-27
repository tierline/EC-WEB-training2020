package com.example.training.web.domain.member;

import com.example.training.web.domain.member.address.Address;
import com.example.training.web.domain.member.address.Block;
import com.example.training.web.domain.member.address.City;
import com.example.training.web.domain.member.address.Postcode;
import com.example.training.web.domain.member.address.Prefecture;
import com.example.training.web.domain.member.form.MemberApplicationForm;

import lombok.Getter;

/**
 * 会員クラス
 */
@Getter
public class Member {
	public static final String SESSION_NAME = "MEMBER";
	/**
	 * 会員ID
	 */
	private MemberId id;
	/**
	 * 会員パスワード（ハッシュ値）
	 */
	private DigestPassword digestPassword;
	/**
	 * 氏名
	 */
	private FullName fullName;
	/**
	 * 住所
	 */
	private Address address;
	/**
	 * Eメール
	 */
	private Email email;
	/**
	 * 電話番号
	 */
	private PhoneNumber phoneNumber;
	/**
	 * 最終更新者
	 */
	private String lastUpdatedBy;
	/**
	 * 承認状態
	 */
	private String status; // fix
	/**
	 * 権限
	 */
	private String roles = "ROLE_USER"; // fix: Role自作

	/**
	 * DBから取得するためのコンストラクタ
	 *
	 * @param entity
	 */
	public Member(MemberEntity entity) {
		this.id = new MemberId(entity.getMemberId());
		this.digestPassword = new DigestPassword(entity.getPassword());
		this.email = new Email(entity.getEmail());
		this.fullName = new FullName(entity.getLastName(), entity.getFirstName());
		this.address = new Address(new Postcode(entity.getPostcode()), new Prefecture(entity.getPrefecture()),
				new City(entity.getCity()), new Block(entity.getBlock()));
		this.phoneNumber = new PhoneNumber(entity.getPhoneNumber());
		this.status = entity.getStatus();
		this.lastUpdatedBy = entity.getLastUpdatedBy();
	}

	/**
	 * 新規会員登録時のコンストラクタ
	 *
	 * @param memberApplicationForm
	 * @param passwordDigest
	 */
	public Member(MemberApplicationForm memberApplicationForm, DigestPassword passwordDigest) {
		this.digestPassword = passwordDigest;
		this.email = new Email(memberApplicationForm.getEmail());
		this.lastUpdatedBy = "none";
		this.status = "unapproved";
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public Member() {

	}

	/*
	 * ログイン認証時に使う
	 */
	public String getDigestPassword() {
		return this.digestPassword.getValue();
	}

}

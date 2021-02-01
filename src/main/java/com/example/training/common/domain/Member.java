package com.example.training.common.domain;

import com.example.training.common.domain.value.DigestPassword;
import com.example.training.common.domain.value.Email;
import com.example.training.common.domain.value.FullName;
import com.example.training.common.domain.value.MemberStatus;
import com.example.training.common.domain.value.Name;
import com.example.training.common.domain.value.PhoneNumber;
import com.example.training.common.domain.value.Role;
import com.example.training.common.domain.value.address.Address;
import com.example.training.common.domain.value.address.Block;
import com.example.training.common.domain.value.address.City;
import com.example.training.common.domain.value.address.Postcode;
import com.example.training.common.domain.value.address.Prefecture;
import com.example.training.common.domain.value.id.MemberId;
import com.example.training.common.entity.MemberEntity;
import com.example.training.web.controller.member.MemberApplicationCommand;
import com.example.training.web.controller.member.MemberEditCommand;

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
	private MemberId memberId;
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
	private Name lastUpdate;
	/**
	 * 承認状態
	 */
	private MemberStatus status;
	/**
	 * 権限
	 */
	private Role roles = new Role("ROLE_USER");

	/**
	 * DBから取得するためのコンストラクタ
	 *
	 * @param entity
	 */
	public Member(MemberEntity entity) {
		this.memberId = new MemberId(entity.getMemberId());
		this.digestPassword = new DigestPassword(entity.getPassword());
		this.email = new Email(entity.getEmail());
		this.fullName = new FullName(new Name(entity.getLastName()), new Name(entity.getFirstName()));
		this.address = new Address(new Postcode(entity.getPostcode()), new Prefecture(entity.getPrefecture()),
				new City(entity.getCity()), new Block(entity.getBlock()));
		this.phoneNumber = new PhoneNumber(entity.getPhoneNumber());
		this.status = entity.getStatus();
		this.lastUpdate = new Name(entity.getLastUpdate());
	}

	/**
	 * 新規会員登録時のコンストラクタ
	 *
	 * @param memberApplicationCommand
	 * @param passwordDigest
	 */

	public Member(MemberApplicationCommand memberApplicationCommand, DigestPassword passwordDigest) {
		this.digestPassword = passwordDigest;
		this.email = new Email(memberApplicationCommand.getEmail());
		this.lastUpdate = new Name("none");
		this.status = MemberStatus.UNAPPROVED;
	}

	/**
	 * 注文時の会員情報更新のためのコンストラクタ
	 *
	 * @param order 注文内容
	 */
	public Member(Order order) {
		this.fullName = order.getFullName();
		this.phoneNumber = order.getPhoneNumber();
		this.address = order.getAddress();
		this.memberId = order.getMemberId();
	}

	/**
	 * 会員情報編集のためのコンストラクタ
	 *
	 * @param memberEditCommand
	 * @param adminName
	 * @param memberId
	 */
	public Member(MemberEditCommand memberEditCommand, Name adminName, MemberId memberId) {
		this.memberId = memberId;
		this.lastUpdate = adminName;
		this.status = MemberStatus.valueOf(memberEditCommand.getStatus());
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public Member() {

	}

}

package com.example.training.common.entity;

import com.example.training.common.domain.Member;
import com.example.training.common.domain.value.DigestPassword;
import com.example.training.common.domain.value.Email;
import com.example.training.common.domain.value.MemberStatus;
import com.example.training.common.domain.value.Role;

import lombok.Getter;

/**
 * キャスト用エンティティ（DB取得時）
 */
@Getter
public class MemberEntity {
	private Long memberId;
	private String email;
	private String password;
	private String lastName;
	private String firstName;
	private String phoneNumber;
	private String postcode;
	private String prefecture;
	private String city;
	private String block;
	private MemberStatus status;
	private String lastUpdate;
	private Role roles = Role.ROLE_USER;

	/**
	 * 基本コンストラクタ
	 */
	public MemberEntity(Member member) {
		this.memberId = member.getMemberId().getValue();
		this.email = member.getEmail().getValue();
		this.password = member.getDigestPassword().getValue();
		this.lastName = member.getFullName().getLastName().getValue();
		this.firstName = member.getFullName().getFirstName().getValue();
		this.phoneNumber = member.getPhoneNumber().getValue();
		this.postcode = member.getAddress().getPostcode().getValue();
		this.prefecture = member.getAddress().getPrefecture().getValue();
		this.city = member.getAddress().getCity().getValue();
		this.block = member.getAddress().getBlock().getValue();
		this.status = member.getStatus();
		this.lastUpdate = member.getLastUpdate().getValue();
		this.roles = member.getRoles();
	}

	/**
	 * 新規会員登録のためのコンストラクタ
	 */
	public MemberEntity(Email email, DigestPassword password, MemberStatus status) {
		this.email = email.getValue();
		this.password = password.getValue();
		this.status = status;
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public MemberEntity() {

	}

}

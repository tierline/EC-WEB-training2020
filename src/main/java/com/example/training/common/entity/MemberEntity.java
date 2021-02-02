package com.example.training.common.entity;

import com.example.training.common.domain.value.MemberStatus;
import com.example.training.common.domain.value.Role;

import lombok.Data;

/**
 * キャスト用エンティティ（DB取得時）
 */
@Data
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

}

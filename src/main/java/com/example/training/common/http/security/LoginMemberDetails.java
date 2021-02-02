package com.example.training.common.http.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.example.training.common.domain.Member;
import com.example.training.common.domain.value.Role;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class LoginMemberDetails extends User {
	private static final long serialVersionUID = 1L;

	private Member member;

	/**
	 * データベースより検索したuserエンティティよりSpring Securityで使用するユーザー認証情報のインスタンスを生成する。
	 *
	 * @param member memberエンティティ
	 */
	public LoginMemberDetails(Member member) {
		super(member.getEmail().getValue(), member.getDigestPassword().getValue(), createRole()); // fix
		this.member = member;
	}

	public Member getMember() {
		return member;
	}

	/*
	 * roleのセット
	 */
	private static Collection<? extends GrantedAuthority> createRole() {
		return AuthorityUtils.commaSeparatedStringToAuthorityList(Role.ROLE_USER.toString());
	}

}

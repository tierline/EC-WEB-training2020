package com.example.training.web.domain.member;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoginMemberDetails extends User {
	private static final long serialVersionUID = 1L;
	// DBより検索したMemberエンティティ
	// アプリケーションから利用されるのでフィールドに定義
	private Member member;

	/**
	 * データベースより検索したuserエンティティよりSpring Securityで使用するユーザー認証情報のインスタンスを生成する。
	 *
	 * @param member memberエンティティ
	 */
	public LoginMemberDetails(Member member) {
		super(member.getEmail().getValue(), member.getPassword().getValue(), createRole());
		this.member = member;
	}

	public Member getMember() {
		return member;
	}

	/*
	 * roleのセット
	 */
	private static Collection<? extends GrantedAuthority> createRole() {
		String role = Role.ROLE_USER.toString();
		return AuthorityUtils.commaSeparatedStringToAuthorityList(role);
	}

}

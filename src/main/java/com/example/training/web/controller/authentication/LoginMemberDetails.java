package com.example.training.web.controller.authentication;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.example.training.web.domain.member.Member;
import com.example.training.web.domain.member.Role;

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
	 * データベースより検索したuserエンティティよりSpring Securityで使用するユーザー認証情報のインスタンスを作る。
	 *
	 * @param member memberエンティティ
	 */
	public LoginMemberDetails(Member member) {
<<<<<<< HEAD
		super(member.getEmail(), member.getDigestPassword(), createRole());
=======
		super(member.getEmail().getValue(), member.getDigestPassword().getValue(), createRole(member)); // fix
>>>>>>> origin/kato
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

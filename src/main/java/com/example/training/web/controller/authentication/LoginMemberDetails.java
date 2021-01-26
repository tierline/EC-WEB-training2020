package com.example.training.web.controller.authentication;

import java.util.Collection;

import com.example.training.web.domain.member.Member;

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
		super(member.getEmail().toString(), member.getDigestPassword(), createRole(member)); // fix
		this.member = member;
	}

	public Member getMember() {
		return member;
	}

	private static Collection<? extends GrantedAuthority> createRole(Member member) {
		String authorityString = member.getRoles();
		return AuthorityUtils.commaSeparatedStringToAuthorityList(authorityString);
	}

}

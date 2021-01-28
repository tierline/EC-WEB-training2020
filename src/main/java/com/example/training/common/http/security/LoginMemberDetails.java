package com.example.training.common.http.security;

import java.util.Collection;

import com.example.training.common.domain.Member;

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
	 * データベースより検索したuserエンティティよりSpring Securityで使用するユーザー認証情報のインスタンスを作る。
	 *
	 * @param member memberエンティティ
	 */
	public LoginMemberDetails(Member member) {
		super(member.getEmail().getValue(), member.getDigestPassword().getValue(), createRole(member)); // fix
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

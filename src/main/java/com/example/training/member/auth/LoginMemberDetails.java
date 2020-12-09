package com.example.training.member.auth;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.training.member.domain.Member;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
		super(member.getEmail(), member.getPassword(), convertGrantedAuthorities(member.getRoles()));
		this.member = member;
	}

	public Member getMember() {
		return member;
	}

	/**
	 * カンマ区切りのロールをSimpleGrantedAuthorityのコレクションへ交換する
	 *
	 * @parm roles カンマ区切りのロール
	 * @return SimpleGrantedAuthorityのコレクション
	 */
	static Set<GrantedAuthority> convertGrantedAuthorities(String roles) {
		if (roles == null || roles.isEmpty()) {
			return Collections.emptySet();
		}
		Set<GrantedAuthority> authorities = Stream.of(roles.split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toSet());
		return authorities;
	}

}

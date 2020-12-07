package com.example.training.member.auth;

import com.example.training.member.domain.Member;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoginUserDetails extends User {
	private static final long serialVersionUID = 1L;
	// DBより検索したMemberエンティティ
	// アプリケーションから利用されるのでフィールドに定義
	private final Member member;

	public LoginUserDetails(Member member, String role) {
		super(member.getEmail(), member.getPassword(), AuthorityUtils.createAuthorityList(role));
		this.member = member;
	}
}

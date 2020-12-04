package com.example.training.member;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.example.training.member.domain.Member;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoginUserDetails extends User {
	private final Member member;

	public LoginUserDetails(Member member, String role) {
		super(member.getEmail(), member.getPassword(), AuthorityUtils.createAuthorityList(role));
		this.member = member;
	}
}

package com.example.training.member.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.training.domain.RawPassword;

import lombok.Getter;

public class DigestPassword {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Getter
	private String value;

	/*
	 * passwordの暗号化
	 */
	public DigestPassword(String password) {
		this.value = passwordEncoder.encode(password);
	}

	public DigestPassword(RawPassword rawPassword) {
		this.value = passwordEncoder.encode(rawPassword.getValue());
	}

	/*
	 * passwordがあっているか
	 */

}

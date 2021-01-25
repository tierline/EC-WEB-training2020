package com.example.training.domain.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class DigestPassword {

	@Autowired
	private PasswordEncoder passwordEncoder;

	private String value;

	public DigestPassword(String password) {
		this.value = password;
	}

	/*
	 * passwordの暗号化
	 */
	public DigestPassword(RawPassword rawPassword) {
		this.value = passwordEncoder.encode(rawPassword.getValue());
	}

	public String getValue() {
		return this.value;
	}

}

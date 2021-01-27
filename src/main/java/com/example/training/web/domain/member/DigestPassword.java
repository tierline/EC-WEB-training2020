package com.example.training.web.domain.member;

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

	/*
	 * passwordの暗号化
	 */
	public DigestPassword(MemberApplicationForm memberApplicationForm) {
		String rawPassword = memberApplicationForm.getPassword();
		this.value = passwordEncoder.encode(rawPassword);
	}

	public String getValue() {
		return this.value;
	}

}

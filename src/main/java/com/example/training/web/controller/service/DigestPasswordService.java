package com.example.training.web.controller.service;

import com.example.training.common.domain.value.DigestPassword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DigestPasswordService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	/*
	 * 暗号化パスワードの生成
	 */
	public DigestPassword generate(String rawPassword) {
		String digest = passwordEncoder.encode(rawPassword);
		return new DigestPassword(digest);
	}

}

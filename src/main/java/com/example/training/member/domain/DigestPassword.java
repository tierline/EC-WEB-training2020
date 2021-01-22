package com.example.training.member.domain;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class DigestPassword {
	private String digest;

	public BCryptPasswordEncoder encoder(String password) {
		return new BCryptPasswordEncoder();
	}
}
//素の値からパスワードに変換するメソッド

package com.example.training.web.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.training.common.repository.MemberRepository;
import com.example.training.common.repository.MemberRepository;
import com.example.training.common.repository.MemberRepository;
import com.example.training.web.domain.member.DigestPassword;
import com.example.training.web.domain.member.Email;
import com.example.training.web.domain.member.MemberEntity;
import com.example.training.web.domain.member.form.MemberLoginForm;
import com.example.training.web.domain.member.form.MemberLoginForm;
import com.example.training.web.domain.member.form.MemberLoginForm;
import com.example.training.web.domain.member.form.MemberLoginForm;

@Service
public class DigestPasswordService {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/*
	 * 登録されているパスワードと一致するか
	 */
	// TODO
	public Boolean isMatched(MemberLoginForm memberLoginForm) {
		Email email = new Email(memberLoginForm.getEmail());
		String rawPassword = memberLoginForm.getPassword();
		MemberEntity memberEntity = memberRepository.findByEmail(email).orElseThrow();
		String digestPassword = memberEntity.getPassword();
		return bCryptPasswordEncoder.matches(rawPassword, digestPassword);
	}

	/*
	 * 暗号化パスワードの生成
	 */
	public DigestPassword generate(String password) {
		String digest = passwordEncoder.encode(password);
		return new DigestPassword(digest);
	}

}

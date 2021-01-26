package com.example.training.web.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.training.common.repository.MemberRepository;
import com.example.training.web.domain.MemberSession;
import com.example.training.web.domain.member.Email;
import com.example.training.web.domain.member.MemberLoginForm;

@Service
public class DigestPasswordService {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public Boolean isMatched(MemberLoginForm memberLoginForm) {
		Email email = new Email(memberLoginForm.getEmail());
		String raw = memberLoginForm.getPassword();
		MemberSession memberSession = memberRepository.findByEmailSession(email).orElseThrow();
		String digest = memberSession.getPassword();
		return bCryptPasswordEncoder.matches(raw, digest);
	}
}

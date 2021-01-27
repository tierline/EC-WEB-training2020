
package com.example.training.web.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.training.common.repository.MemberRepository;
import com.example.training.web.domain.member.Email;
import com.example.training.web.domain.member.Member;
import com.example.training.web.domain.member.MemberApplicationForm;

@Service
public class MemberApplicationService {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private MemberRepository memberRepository;

	/*
	 * 新規会員登録処理
	 */
	@Transactional
	public void run(MemberApplicationForm memberApplicationForm) {
//		DigestPassword digestPassword = new DigestPassword(memberApplicationForm);
		Email email = new Email(memberApplicationForm.getEmail());
		String password = memberApplicationForm.getPassword();
		String passwordDigest = passwordEncoder.encode(password);
		Member member = memberApplicationForm.createMember(email, passwordDigest);
		memberRepository.create(member);
	}
}


package com.example.training.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.training.member.domain.Member;
import com.example.training.member.domain.form.MemberApplicationForm;
import com.example.training.member.repository.MemberRepository;

@Service
public class MemberApplicationService {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private MemberRepository memberRepository;

	@Transactional
	public void run(MemberApplicationForm memberApplicationForm) {
		String password = memberApplicationForm.getPassword();
		String passwordDigest = passwordEncoder.encode(password);
		Member member = memberApplicationForm.createMember(passwordDigest);
		memberRepository.create(member);
	}
}

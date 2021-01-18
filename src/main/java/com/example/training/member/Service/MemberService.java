package com.example.training.member.Service;

import com.example.training.member.domain.MemberApplicationForm;
import com.example.training.member.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private MemberRepository memberRepository;

	@Transactional
	public void applicate(MemberApplicationForm memberApplicationForm) {
		String password = memberApplicationForm.getPassword();
		String digest = passwordEncoder.encode(password);
		// memberApplicateForm が Memberを作る
		memberRepository.create(memberApplicationForm, digest);// Repository の引数に Form は使わない //
																														// memberRepository.create(member);
	}

}

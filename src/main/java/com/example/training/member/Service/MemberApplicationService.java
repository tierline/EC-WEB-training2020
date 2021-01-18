package com.example.training.member.Service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.training.member.domain.Member;
import com.example.training.member.domain.MemberApplicateForm;
import com.example.training.member.repository.MemberRepository;

@Service
public class MemberApplicationService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private MemberRepository memberRepository;

//	@Transactional
//	public void create(MemberApplicateForm memberApplicateForm) {
//		String password = memberApplicateForm.getPassword();
//		String digest = passwordEncoder.encode(password);
//		// memberApplicateForm が Memberを作る
//		memberRepository.create(memberApplicateForm, digest);// Repository の引数に Form は使わない //
//																// memberRepository.create(member);
//	}

	@Transactional
	public void run(@Valid MemberApplicateForm memberApplicateForm) {
		String password = memberApplicateForm.getPassword();
		String digest = passwordEncoder.encode(password);
		Member newMember = new Member(memberApplicateForm);
		memberRepository.create(newMember, digest);
	}

}

package com.example.training.mobile.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import com.example.training.common.repository.MemberRepository;
import com.example.training.web.domain.member.Member;
import com.example.training.web.domain.member.MemberApplicationForm;
import com.example.training.web.domain.member.MemberEntity;
import com.example.training.web.domain.member.MemberLoginForm;
import com.example.training.web.domain.service.MemberApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")

public class ApiMemberController {

	@Autowired
	private HttpSession session;

	@Autowired
	private MemberApplicationService memberApplicationService;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@CrossOrigin
	@PostMapping("/applicate")
	@ResponseBody
	public Boolean applicate(@RequestBody MemberApplicationForm memberApplicationForm) {
		Optional<MemberEntity> memberOpt = memberRepository.findByEmail(memberApplicationForm.getEmail());
		if (memberOpt.isEmpty()) {
			memberApplicationService.run(memberApplicationForm);
			Optional<MemberEntity> member = memberRepository.findByEmail(memberApplicationForm.getEmail());
			session.setAttribute(Member.SESSION_NAME, member);
			return true;
		} else {
			return false;
		}
	}

	// fix
	@CrossOrigin
	@PostMapping("/login")
	@ResponseBody
	public Boolean login(@RequestBody MemberLoginForm memberLoginForm) {
		String password = memberLoginForm.getPassword();
		MemberEntity memberEntity = memberRepository.findByEmail(memberLoginForm.getEmail()).orElseThrow();
		String hashPassword = memberEntity.getPassword();
		Boolean isMatched = bCryptPasswordEncoder.matches(password, hashPassword);
		if (isMatched) {
			Member member = new Member(memberEntity);
			session.setAttribute(Member.SESSION_NAME, member);
		}
		return isMatched;
	}

	/*
	 * 住所情報があったら表示する
	 */
	@GetMapping("/session")
	@ResponseBody
	public Member fetchMemberSession() {
		Member member = (Member) session.getAttribute(Member.SESSION_NAME); // fix
		return member;
	}

}

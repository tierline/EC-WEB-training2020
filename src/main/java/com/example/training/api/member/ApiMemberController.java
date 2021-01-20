package com.example.training.api.member;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import com.example.training.member.domain.Member;
import com.example.training.member.domain.MemberApplicationForm;
import com.example.training.member.domain.MemberLoginForm;
import com.example.training.member.repository.MemberRepository;
import com.example.training.member.service.MemberApplicationService;

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
		Optional<Member> member = memberRepository.findByEmail(memberApplicationForm.getEmail());
		if (member.isEmpty()) {
			memberApplicationService.run(memberApplicationForm);
			Optional<Member> memberDetail = memberRepository.findByEmail(memberApplicationForm.getEmail());
			session.setAttribute(Member.SESSION_NAME, memberDetail.get());
			return true;
		} else {
			return false;
		}
	}

	@CrossOrigin
	@PostMapping("/login")
	@ResponseBody
	public Boolean login(@RequestBody MemberLoginForm memberLoginForm) {
		String password = memberLoginForm.getPassword();
		Member member = memberRepository.findByEmail(memberLoginForm.getEmail()).orElseThrow();
		String hashPassword = member.getPassword();
		Boolean isMatched = bCryptPasswordEncoder.matches(password, hashPassword);
		if (isMatched) {
			session.setAttribute(Member.SESSION_NAME, member);
		}
		return isMatched;
	}

	/*
	 * 住所情報があったら表示する
	 */
	@GetMapping("/session")
	@ResponseBody
	public Member fetchMemberAddress() {
		Member member = (Member) session.getAttribute(Member.SESSION_NAME);
		return member;
	}

}

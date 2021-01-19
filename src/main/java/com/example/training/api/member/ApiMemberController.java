package com.example.training.api.member;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import com.example.training.member.domain.Member;
import com.example.training.member.domain.form.MemberApplicationForm;
import com.example.training.member.domain.form.MemberLoginForm;
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
	public Boolean create(@RequestBody MemberApplicationForm memberApplicationForm) {
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
		Optional<Member> memberDetail = memberRepository.findByEmail(memberLoginForm.getEmail());
		if (memberDetail.isPresent()) {
			String hashPassword = memberDetail.get().getPassword();
			Boolean result = bCryptPasswordEncoder.matches(password, hashPassword);
			session.setAttribute(Member.SESSION_NAME, memberDetail.get());
			return result;
		}
		return false;

	}

	/*
	 * 住所情報があったら表示する
	 */
	@GetMapping("/session")
	public Member fetchMemberAddress() {
		Member member = (Member) session.getAttribute(Member.SESSION_NAME);// member型 で address の変数名はおかしい
		return member;
	}

}

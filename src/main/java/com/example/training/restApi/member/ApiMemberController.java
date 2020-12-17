package com.example.training.restApi.member;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.training.member.Service.MemberService;
import com.example.training.member.domain.Member;
import com.example.training.member.repository.MemberRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/member")

public class ApiMemberController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/applicate")
	@ResponseBody
	public Member create(@RequestBody Member member) {
		memberService.create(member);
		return member;
	}

	@PostMapping("/login")
	@ResponseBody
	public Boolean login(@RequestBody Member member) {
		String password = member.getPassword();
		Optional<Member> memberDetail = memberRepository.findByEmail(member.getEmail());
		if (memberDetail.isPresent()) {
			String hashPassword = memberDetail.get().getPassword();
			Boolean result = bCryptPasswordEncoder.matches(password, hashPassword);
			return result;
		}
		return false;

	}
}

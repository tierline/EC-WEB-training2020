package com.example.training.mobile.controller.member;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import com.example.training.common.domain.Member;
import com.example.training.common.domain.value.Email;
import com.example.training.common.entity.MemberEntity;
import com.example.training.common.http.MemberSession;
import com.example.training.common.repository.MemberRepository;
import com.example.training.common.service.MemberApplicationService;
import com.example.training.web.controller.member.MemberApplicationCommand;
import com.example.training.web.controller.member.MemberDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会員のコントローラ(Mobile)
 */
// TODO: ApiMemberC -> MemberController
@RestController
@RequestMapping("/api/member")

public class MemberControllerAPI {

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
	// TODO ~command
	public Boolean applicate(MemberApplicationCommand memberApplicationCommand) {
		Email email = new Email(memberApplicationCommand.getEmail());
		Optional<MemberEntity> memberOpt = memberRepository.findByEmail(email);
		if (memberOpt.isEmpty()) {
			memberApplicationService.run(memberApplicationCommand);
			Optional<MemberEntity> memberEntity = memberRepository.findByEmail(email);
			Member member = new Member(memberEntity.get());
			MemberSession memberSession = new MemberSession(member);
			session.setAttribute(Member.SESSION_NAME, memberSession);
			return true;
		} else {
			return false;
		}
	}

	/**
	 *
	 *
	 * @param memberLoginCommand
	 * @return
	 */
	// @CrossOrigin
	// @PostMapping("/login")
	// @ResponseBody
	// public String login(@RequestBody MemberLoginCommand memberLoginCommand) {
	// String password = memberLoginCommand.getPassword();
	// Email email = new Email(memberLoginCommand.getEmail());
	// MemberEntity memberEntity =
	// memberRepository.findByEmail(email).orElseThrow();
	// String hashPassword = memberEntity.getPassword();
	// Boolean isMatched = bCryptPasswordEncoder.matches(password, hashPassword);
	// if (isMatched) {
	// Member member = new Member(memberEntity);
	// MemberSession memberSession = new MemberSession(member);
	// session.setAttribute(Member.SESSION_NAME, memberSession);
	// }
	// return isMatched;
	// return "/api/member/login";
	// }
	/*
	 * 会員のセッション情報を取得する。
	 */
	@GetMapping("/session")

	@ResponseBody
	public MemberDTO fetchMemberSession() {
		MemberSession member = (MemberSession) session.getAttribute(Member.SESSION_NAME);
		Email email = member.getEmail();
		MemberEntity memberEntity = memberRepository.findByEmail(email).orElseThrow();
		MemberDTO memberDTO = new MemberDTO(memberEntity);
		return memberDTO;
	}

}

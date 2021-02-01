package com.example.training.mobile.controller.member;

import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.training.common.domain.Member;
import com.example.training.common.domain.value.Email;
import com.example.training.common.entity.MemberEntity;
import com.example.training.common.http.MemberSession;
import com.example.training.common.repository.MemberRepository;
import com.example.training.common.service.MemberApplicationService;
import com.example.training.web.controller.member.MemberApplicationCommand;
import com.example.training.web.controller.member.MemberDTO;

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

	/*
	 * 新規登録処理 登録完了後ログイン
	 */
	@CrossOrigin
	@PostMapping("/applicate")
	// TODO ~command
	public ResponseEntity<Boolean> applicate(MemberApplicationCommand memberApplicationCommand,
			HttpServletRequest request) throws ServletException {
		Email email = new Email(memberApplicationCommand.getEmail());
		Optional<MemberEntity> memberOpt = memberRepository.findByEmail(email);
		if (memberOpt.isEmpty()) {
			memberApplicationService.run(memberApplicationCommand);
			MemberEntity entity = memberRepository.findByEmail(email).orElseThrow();
			MemberSession memberSession = new MemberSession(entity);
			session.setAttribute(Member.SESSION_NAME, memberSession);
			request.login(memberApplicationCommand.getEmail(), memberApplicationCommand.getPassword());
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
	}

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

<<<<<<< HEAD:src/main/java/com/example/training/mobile/ApiMemberController.java
package com.example.training.mobile;
=======
package com.example.training.mobile.controller;
>>>>>>> origin/kato:src/main/java/com/example/training/mobile/controller/ApiMemberController.java

import java.util.Optional;

import javax.servlet.http.HttpSession;

<<<<<<< HEAD:src/main/java/com/example/training/mobile/ApiMemberController.java
=======
import com.example.training.common.repository.MemberRepository;
import com.example.training.web.domain.member.Member;
import com.example.training.web.domain.member.MemberApplicationForm;
import com.example.training.web.domain.member.MemberEntity;
import com.example.training.web.domain.member.MemberLoginForm;
import com.example.training.web.domain.service.MemberApplicationService;

>>>>>>> origin/kato:src/main/java/com/example/training/mobile/controller/ApiMemberController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.training.common.repository.MemberRepository;
import com.example.training.web.domain.MemberEntity;
import com.example.training.web.domain.MemberSession;
import com.example.training.web.domain.member.Email;
import com.example.training.web.domain.member.Member;
import com.example.training.web.domain.member.MemberApplicationForm;
import com.example.training.web.domain.member.MemberLoginForm;
import com.example.training.web.domain.service.DigestPasswordService;
import com.example.training.web.domain.service.MemberApplicationService;

@RestController
@RequestMapping("/api/member")

public class ApiMemberController {

	@Autowired
	private HttpSession session;

	@Autowired
	private MemberApplicationService memberApplicationService;

	@Autowired
	private DigestPasswordService digestPasswordService;

	@Autowired
	private MemberRepository memberRepository;

//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@CrossOrigin
	@PostMapping("/applicate")
	@ResponseBody
	public Boolean applicate(@RequestBody MemberApplicationForm memberApplicationForm) {
<<<<<<< HEAD:src/main/java/com/example/training/mobile/ApiMemberController.java
		Email email = new Email(memberApplicationForm.getEmail());
		Optional<MemberEntity> member = memberRepository.findByEmail(email);
		if (member.isEmpty()) {
			memberApplicationService.run(memberApplicationForm);
			MemberSession memberSession = memberRepository.findByEmailSession(email).orElseThrow();
			session.setAttribute(Member.SESSION_NAME, memberSession);
=======
		Optional<MemberEntity> memberOpt = memberRepository.findByEmail(memberApplicationForm.getEmail());
		if (memberOpt.isEmpty()) {
			memberApplicationService.run(memberApplicationForm);
			Optional<MemberEntity> member = memberRepository.findByEmail(memberApplicationForm.getEmail());
			session.setAttribute(Member.SESSION_NAME, member);
>>>>>>> origin/kato:src/main/java/com/example/training/mobile/controller/ApiMemberController.java
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
<<<<<<< HEAD:src/main/java/com/example/training/mobile/ApiMemberController.java
		Email email = new Email(memberLoginForm.getEmail());
		Boolean isMatched = digestPasswordService.isMatched(memberLoginForm);
		if (isMatched) {
			MemberSession memberSession = memberRepository.findByEmailSession(email).orElseThrow();
			session.setAttribute(Member.SESSION_NAME, memberSession);
=======
		String password = memberLoginForm.getPassword();
		MemberEntity memberEntity = memberRepository.findByEmail(memberLoginForm.getEmail()).orElseThrow();
		String hashPassword = memberEntity.getPassword();
		Boolean isMatched = bCryptPasswordEncoder.matches(password, hashPassword);
		if (isMatched) {
			Member member = new Member(memberEntity);
			session.setAttribute(Member.SESSION_NAME, member);
>>>>>>> origin/kato:src/main/java/com/example/training/mobile/controller/ApiMemberController.java
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

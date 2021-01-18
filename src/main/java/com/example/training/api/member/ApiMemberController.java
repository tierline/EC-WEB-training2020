package com.example.training.api.member;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import com.example.training.member.Service.MemberApplicationService;
import com.example.training.member.domain.Email;
import com.example.training.member.domain.Member;
import com.example.training.member.domain.MemberApplicateForm;
import com.example.training.member.domain.MemberLoginForm;
import com.example.training.member.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	private MemberApplicationService memberService;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@CrossOrigin
	@PostMapping("/applicate")
	@ResponseBody
	public Boolean create(@RequestBody MemberApplicateForm memberApplicateForm) {
		Optional<Member> member = memberRepository.findByEmail(memberApplicateForm.getEmail());
		if (member.isEmpty()) {
			memberService.create(memberApplicateForm);
			Optional<Member> memberDetail = memberRepository.findByEmail(memberApplicateForm.getEmail());
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
	// TOREVIEW 要修正、sessionから取得する？ DBから取得するのはあまり問題なし。アプリケーションによる。
	// session の乱用は流石に危険。session は変更があった場合など、考えなければならない材料が増える
	// 値オブジェクトをいい感じにしたい
	@PostMapping("/address")
	@ResponseBody
	public Member fetchMemberAddress(@RequestBody Email email) {
		Member member = memberRepository.findAddress(email.getEmail()); // member型 で address の変数名はおかしい
		return member;
	}

}

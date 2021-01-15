
package com.example.training.member.controller;

import java.util.Locale;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.example.training.member.Service.MemberService;
import com.example.training.member.domain.Member;
import com.example.training.member.domain.MemberApplicateForm;
import com.example.training.member.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

	String redirect = "redirect:/member";

	@Autowired
	protected HttpSession session;

	@Autowired
	private MemberService memberService;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	protected MessageSource messageSource;

	/**
	 * 会員のログインページを表示する
	 */
	@GetMapping("/login")
	public String login() {
		if (session.getAttribute(Member.SESSION_NAME) == null) {
			return "member/login";
		} else {
			return "redirect:/";
		}
	}

	/**
	 * 会員登録ページを表示する
	 */
	@GetMapping("applicate")
	public String applicate(MemberApplicateForm memberApplicateForm, Model model) {
		model.addAttribute("memberApplicateForm", memberApplicateForm);
		return "member/applicate";
	}

	/**
	 * 会員登録完了ページを表示する
	 */
	@GetMapping("applicated")
	public String applicated() {
		return "member/applicated";
	}

	/**
	 * 会員を新規登録する
	 */
	// TOREVIEW もうちょっとなにかできそうな気がする
	@PostMapping("applicate")
	public String applicate(@Valid MemberApplicateForm memberApplicateForm, BindingResult result, Model model) {
		String email = memberApplicateForm.getEmail();
		Optional<Member> member = memberRepository.findByEmail(email);
		if (result.hasErrors()) {
			return applicate(memberApplicateForm, model);
		} else if (memberApplicateForm.isExistedMember(member)) {
			model.addAttribute("errorMessage",
					messageSource.getMessage("error.applicate.duplicate", null, Locale.JAPAN));
			return "member/applicate";
		} else {
			memberService.create(memberApplicateForm);
			return "redirect:/member/applicated";
		}
	}
}

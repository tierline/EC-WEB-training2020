
package com.example.training.web.controller.member;

import java.util.Locale;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.example.training.common.domain.Member;
import com.example.training.common.entity.MemberEntity;
import com.example.training.common.repository.MemberRepository;
import com.example.training.common.service.MemberApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 会員のコントローラ
 */
@Controller
@RequestMapping("/member")
public class MemberController {

	String redirect = "redirect:/member";

	@Autowired
	protected HttpSession session;

	@Autowired
	private MemberApplicationService memberApplicationService;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	protected MessageSource messageSource;

	/**
	 * 会員のログインページを表示する。
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
	 * 会員登録ページを表示する。
	 */
	@GetMapping("applicate")
	public String applicate(MemberApplicationCommand memberApplicationCommand, Model model) {
		model.addAttribute("memberApplicationCommand", memberApplicationCommand);
		return "member/applicate";
	}

	/**
	 * 会員登録完了ページを表示する。
	 */
	@GetMapping("applicated")
	public String applicated() {
		return "member/applicated";
	}

	/**
	 * 会員の新規登録処理をする。
	 *
	 * @param command
	 * @param result
	 * @param model
	 * @return 完了画面
	 */
	@PostMapping("applicate")
	public String applicate(@Valid MemberApplicationCommand command, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return applicate(command, model);
		}
		Optional<MemberEntity> memberEntity = memberRepository.findByEmail(command.createEmail());
		if (memberEntity.isPresent()) {
			model.addAttribute("errorMessage", messageSource.getMessage("error.applicate.duplicate", null, Locale.JAPAN));
			return "member/applicate";
		}
		memberApplicationService.run(command);
		return "redirect:/member/applicated";

	}
}

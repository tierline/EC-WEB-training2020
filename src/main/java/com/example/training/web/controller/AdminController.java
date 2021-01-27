package com.example.training.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.training.common.repository.MemberRepository;
import com.example.training.web.domain.admin.Admin;
import com.example.training.web.domain.member.Member;
import com.example.training.web.domain.member.MemberEntity;
import com.example.training.web.domain.member.MemberId;
import com.example.training.web.domain.member.form.MemberEditForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	protected HttpSession session;

	@Autowired
	MemberRepository memberRepository;

	/**
	 * 会員トップ画面を表示する。
	 */
	@GetMapping()
	public String index() {
		return "admin/index";
	}

	/**
	 * 会員のログイン画面を表示する。
	 */
	@GetMapping("/login")
	public String login() {
		if (session.getAttribute(Admin.SESSION_NAME) == null) {
			return "admin/login";
		} else {
			return "redirect:/";
		}
	}

	/**
	 * 会員情報の一覧を表示する。
	 */
	@GetMapping("/members")
	public String list(Model model) {
		List<MemberEntity> member = memberRepository.findAll();
		model.addAttribute("members", member);
		return "admin/members/index";
	}

	/**
	 * 会員情報編集画面を表示する。
	 */
	@GetMapping("/members/{memberId}/edit")
	public String editForm(@PathVariable MemberId memberId, Model model) {
		MemberEntity memberEntity = memberRepository.findById(memberId);
		model.addAttribute("member", memberEntity);
		return "admin/members/edit";
	}

	/**
	 * 会員情報を編集する。
	 */
	@PostMapping("/members/{memberId}/edit")
	public String edit(@PathVariable MemberId memberId, MemberEditForm memberEditForm) {
		Admin admin = (Admin) session.getAttribute(Admin.SESSION_NAME);
		String adminName = admin.getName();
		Member member = new Member(memberEditForm, adminName, memberId);
		memberRepository.updateByAdmin(member);
		return "redirect:/admin/members";
	}

}

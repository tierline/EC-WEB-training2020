package com.example.training.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.training.admin.domain.Admin;
import com.example.training.common.repository.MemberRepository;
import com.example.training.web.domain.MemberEntity;
import com.example.training.web.domain.member.Member;
import com.example.training.web.domain.member.MemberEditForm;
import com.example.training.web.domain.member.MemberId;

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

	@GetMapping()
	public String index() {
		return "admin/index";
	}

	/**
	 * 会員のログイン画面を表示する
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
	 * 会員情報の一覧を表示する
	 */
	@GetMapping("/members")
	public String list(Model model) {
		List<MemberEntity> member = memberRepository.findAll();
		model.addAttribute("members", member);
		return "admin/members/index";
	}

	/**
	 * 会員情報編集画面を表示する
	 */
	@GetMapping("/members/{id}/edit")
	public String editForm(@PathVariable MemberId id, Model model, MemberEditForm memberEditForm) {
		MemberEntity entity = memberRepository.findById(id);
		Member member = new Member(entity);
		model.addAttribute("memberEditForm", member);
		return "admin/members/edit";
	}

	/**
	 * 会員情報を編集する
	 */
	@PostMapping("/members/{id}/edit")
	public String edit(@PathVariable int id, MemberEditForm memberEditForm, Model model) {
		Admin admin = (Admin) session.getAttribute(Admin.SESSION_NAME);
		String lastUpdatedBy = admin.getName();
		memberRepository.update(memberEditForm, lastUpdatedBy);
		return "redirect:/admin/members";
	}

}

package com.example.training.member.controller;

import com.example.training.member.domain.Member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members/auth")
public class MemberLoginController {
	@GetMapping("/login")
	public String loginForm(@ModelAttribute("member") Member member, Model model) {
		return "/members/auth/login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("member") Member member) {
		return "redirect:/";
	}

}

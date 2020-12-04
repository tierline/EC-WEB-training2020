package com.example.training.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.training.member.domain.Member;

@Controller
@RequestMapping("/auth")
public class LoginController {
	@GetMapping("/login")
	public String loginForm() {
		return "/auth/login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("loginForm") Member loginForm) {
		return "redirect:/";
	}

}

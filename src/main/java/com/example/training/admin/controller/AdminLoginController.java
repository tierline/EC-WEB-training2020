package com.example.training.admin.controller;

import com.example.training.admin.domain.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admins/auth")
public class AdminLoginController {
	@GetMapping("/login")
	public String loginForm(@ModelAttribute("admin") Admin admin, Model model) {
		return "/admins/auth/login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("admin") Admin admin) {
		return "redirect:/";
	}

}

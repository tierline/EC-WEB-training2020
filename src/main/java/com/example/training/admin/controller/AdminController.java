package com.example.training.admin.controller;

import com.example.training.member.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admins")
public class AdminController {

  @Autowired
  MemberRepository memberRepository;

  @GetMapping("/")
  public String index() {
    return "/admins/index";
  }

  /**
   * 会員ログイン画面の表示
   */
  @GetMapping("/auth/login")
  public String login() {
    return "/admins/auth/login";
  }

  /**
   * 会員一覧の表示
   */
  @GetMapping("/members")
  public String members(Model model) {
    model.addAttribute("members", memberRepository.findAll());
    return "/admins/members";
  }

}

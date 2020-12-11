package com.example.training.admin.controller;

import javax.servlet.http.HttpSession;

import com.example.training.admin.domain.Admin;
import com.example.training.member.Service.MemberService;
import com.example.training.member.domain.Member;
import com.example.training.member.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admins")
public class AdminController {

  @Autowired
  protected HttpSession session;

  @Autowired
  MemberRepository memberRepository;

  @Autowired
  private MemberService memberService;

  @GetMapping()
  public String index() {
    return "/admins/index";
  }

  /**
   * 会員のログイン画面を表示する
   */
  @GetMapping("/auth/login")
  public String login() {
    if (session.getAttribute(Admin.SESSION_NAME) == null) {
      return "/admins/auth/login";
    } else {
      return "redirect:/";
    }
  }

  /**
   * 会員情報の一覧を表示する
   */
  @GetMapping("/members")
  public String members(Model model) {
    model.addAttribute("members", memberRepository.findAll());
    return "/admins/members";
  }

  /**
   * 会員情報編集画面を表示する
   */
  @GetMapping("/member/{id}/edit")
  public String editForm(@PathVariable int id, Model model) {
    model.addAttribute("member", memberRepository.findById(id));
    return "/admins/member/edit";
  }

  /**
   * 会員情報を編集する
   */
  @PostMapping("/member/{id}/edit")
  public String edit(@PathVariable int id, Member member, Model model) {
    Admin admin = (Admin) session.getAttribute(Admin.SESSION_NAME);
    String lastUpdatedby = admin.getName();
    memberService.update(member, lastUpdatedby);
    return "redirect:/admins/members";
  }

}

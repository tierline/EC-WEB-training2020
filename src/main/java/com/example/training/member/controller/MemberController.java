
package com.example.training.member.controller;

import javax.validation.Valid;

import com.example.training.member.Service.MemberService;
import com.example.training.member.domain.Member;
import com.example.training.member.domain.MemberApplicateForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {

  String redirect = "redirect:/members";

  @Autowired
  private MemberService memberService;

  /**
   * 会員のログイン画面を表示する
   */
  @GetMapping("/auth/login")
  public String login(Model model) {
    return "/members/auth/login";
  }

  /**
   * 会員登録画面を表示する
   */
  @GetMapping("applicate")
  public String applicate(MemberApplicateForm memberApplicateForm, @ModelAttribute("member") Member member,
      Model model) {
    model.addAttribute("memberApplicateForm", memberApplicateForm);
    return "members/applicate";
  }

  /**
   * 会員を新規登録する
   */
  @PostMapping("/applicate")
  public String checkMemberInfo(@Valid MemberApplicateForm memberApplicateForm, @ModelAttribute("member") Member member,
      BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return ("members/applicate");
    } else {
      memberService.create(member);
      return "redirect:/members/auth/login";
    }
  }
}

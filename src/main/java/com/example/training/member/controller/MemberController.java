
package com.example.training.member.controller;

import com.example.training.member.Service.MemberService;
import com.example.training.member.domain.Member;

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
   * 会員ログイン画面の表示
   */
  @GetMapping("/auth/login")
  public String login(Model model) {
    return "/members/auth/login";
  }

  /**
   * 会員編集画面の表示
   */
  @GetMapping("edit")
  public String edit() {
    return "members/edit";
  }

  /**
   * 会員の作成
   */
  @PostMapping("/applicate")
  public String applicate(@ModelAttribute("member") Member member, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return ("members/applicate");
    } else {
      memberService.create(member);
      return redirect;
    }
  }
}

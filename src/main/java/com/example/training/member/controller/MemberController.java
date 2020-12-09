
package com.example.training.member.controller;

import com.example.training.member.Service.MemberService;
import com.example.training.member.domain.Member;
import com.example.training.member.repository.MemberRepository;

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
  private MemberRepository memberRepository;

  @Autowired
  private MemberService memberService;

  /**
   * 会員ログイン画面の表示
   */
  @GetMapping("/auth/login")
  public String login() {
    return "/members/auth/login";
  }

  /**
   * 会員一覧の表示
   */
  @GetMapping
  public String index(Model model) {
    model.addAttribute("members", memberRepository.findAll());
    return "members/index";
  }

  /**
   * 会員作成画面の表示
   */
  @GetMapping("applicate")
  public String create(@ModelAttribute("member") Member member, Model model) {
    return "members/applicate";
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
  public String create(@ModelAttribute("member") Member member, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return ("members/create");
    } else {
      memberService.create(member);
      return redirect;
    }
  }
}


package com.example.training.member.controller;

import javax.servlet.http.HttpSession;
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
@RequestMapping("/member")
public class MemberController {

  String redirect = "redirect:/member";

  @Autowired
  protected HttpSession session;

  @Autowired
  private MemberService memberService;

  /**
   * 会員のログインページを表示する
   */
  @GetMapping("/login")
  public String login() {
    if (session.getAttribute(Member.SESSION_NAME) == null) {
      return "member/login";
    } else {
      return "redirect:/";
    }
  }

  /**
   * 会員登録ページを表示する
   */
  @GetMapping("applicate")
  public String applicate(MemberApplicateForm memberApplicateForm, Model model) {
    model.addAttribute("memberApplicateForm", memberApplicateForm);
    return "member/applicate";
  }

  /**
   * 会員登録完了ページを表示する
   */
  @GetMapping("applicated")
  public String applicated() {
    return "member/applicated";
  }

  /**
   * 会員を新規登録する
   */
  @PostMapping("applicate")
  public String applicate(@ModelAttribute("member") Member member, @Valid MemberApplicateForm memberApplicateForm,
      BindingResult result, Model model) {
    if (result.hasErrors()) {
      return applicate(memberApplicateForm, model);
    } else {
      memberService.create(member);
      return "redirect:/member/applicated";
    }
  }
}

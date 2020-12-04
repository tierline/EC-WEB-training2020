
package com.example.training.controller;

import com.example.training.domain.Member;
import com.example.training.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {

  String redirect = "redirect:/members";

  // @Autowired
  // private MemberService memberService;

  @Autowired
  private MemberRepository memberRepository;

  /**
   * 会員一覧の表示
   */
  @GetMapping
  public String index(Model model) {
    model.addAttribute("members", memberRepository.findAll());
    return "members/index";
  }

  @GetMapping("create")
  public String create(@ModelAttribute("member") Member member, Model model) {
    return "members/create";
  }

  @GetMapping("edit")
  public String edit() {
    return "members/edit";
  }

  /**
   * 会員の作成
   */
  @PostMapping("/create")
  public String create(@ModelAttribute("member") Member member) {
    // if (result.hasErrors()) {
    // return ("members/create");
    // } else {
    // memberService.create(command.getMember());
    memberRepository.create(member);
    return redirect;
    // }
  }
}

// @Valid MemberCreateCommand command, BindingResult
// result

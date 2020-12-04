
package com.example.training.controller;

import javax.validation.Valid;

import com.example.training.MemberService;
import com.example.training.controller.form.MemberCreateCommand;
import com.example.training.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {

  String redirect = "redirect:/members";

  @Autowired
  private MemberService memberService;

  @Autowired
  private MemberRepository memberRepository;

  @GetMapping
  public String index(Model model) {
    model.addAttribute("members", memberRepository.findAll());
    return "members/index";
  }

  @GetMapping("create")
  public String create() {
    return "members/create";
  }

  @GetMapping("edit")
  public String edit() {
    return "members/edit";
  }

  /**
   * 会員（ユーザー）の作成
   */
  @PostMapping("/create")
  public String create(@ModelAttribute("member") @Valid MemberCreateCommand command, BindingResult result,
      Model model) {
    if (result.hasErrors()) {
      return ("members/create");
    } else {
      memberService.save(command.getMember());
      return redirect;
    }
  }
}

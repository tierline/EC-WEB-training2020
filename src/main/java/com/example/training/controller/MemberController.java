
package com.example.training.controller;

import javax.validation.Valid;

import com.example.training.MemberService;
import com.example.training.controller.form.MemberCreateCommand;

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
@RequestMapping("/users")
public class MemberController {

  String redirect = "redirect:/users";

  @Autowired
  private MemberService userService;

  @GetMapping
  public String index() {
    return "users/index";
  }

  @GetMapping("create")
  public String create() {
    return "users/create";
  }

  @GetMapping("edit")
  public String edit() {
    return "users/edit";
  }

  /**
   * 会員（ユーザー）の作成
   */
  @PostMapping("/create")
  public String create(@ModelAttribute("user") @Valid MemberCreateCommand command, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return ("users/create");
    } else {
      userService.save(command.getMember());
      return redirect;
    }
  }
}

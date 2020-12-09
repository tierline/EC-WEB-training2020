package com.example.training.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admins")
public class AdminController {

  /**
   * 会員ログイン画面の表示
   */
  @GetMapping("/auth/login")
  public String login() {
    return "/admins/auth/login";
  }

}

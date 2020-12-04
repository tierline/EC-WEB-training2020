package com.example.training.controller.form;

import com.example.training.domain.Member;

public class MemberCreateCommand {

  private String email;
  private String password;
  private String address;

  public Member getMember() {
    return new Member();
  }
}

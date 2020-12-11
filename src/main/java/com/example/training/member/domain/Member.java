package com.example.training.member.domain;

import lombok.Data;

@Data
public class Member {
  public static final String SESSION_NAME = "MEMBER";
  private int id;
  private String email;
  private String password;
  private String address;
  private String lastUpdatedBy;
  private String roles = "ROLE_USER";

  public Member() {

  }

  public Member(int id, String email, String password, String address, String roles) {
    this.id = id;
    this.email = email;
    this.password = password;
    this.address = address;
    this.lastUpdatedBy = lastUpdatedBy;
    this.roles = roles;
  }

}

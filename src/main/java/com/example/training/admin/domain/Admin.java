package com.example.training.admin.domain;

import lombok.Data;

@Data
public class Admin {
  private int id;
  private String name;
  private String password;

  public Admin() {

  }

  public Admin(int id, String name, String password) {
    this.id = id;
    this.name = name;
    this.password = password;
  }
}

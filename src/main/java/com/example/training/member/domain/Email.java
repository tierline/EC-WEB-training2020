package com.example.training.member.domain;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class Email {

  @NotEmpty
  private String email;
}

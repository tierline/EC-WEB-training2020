package com.example.training.member.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MemberApplicateForm {

  @NotNull
  private String email;

  @NotNull
  @Size(min=2, max=16)
  private String password;

  @NotNull
  @Size(min=2, max=128)
  private String address;

}

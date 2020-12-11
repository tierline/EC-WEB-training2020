package com.example.training.member.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MemberApplicateForm {

  @NotEmpty
  @Email
  @Size(min = 2, max = 5, message = "1文字以上、5文字以内で入力して下さい。")
  private String email;

  @NotEmpty
  @Size(min = 2, max = 16)
  private String password;

  @NotEmpty
  @Size(min = 2, max = 128)
  private String address;

}

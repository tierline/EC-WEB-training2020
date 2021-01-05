package com.example.training.member.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class MemberApplicateForm {

  /**
   * 連絡先情報
   */
  @NotEmpty
  @Email
  @Size(min = 1, max = 128, message = "メールアドレスは1文字以上、128文字以内で入力してください")
  private String email;

  @NotEmpty
  @Size(max = 16, message = "パスワードは16文字以内で入力してください")
  private String password;

}

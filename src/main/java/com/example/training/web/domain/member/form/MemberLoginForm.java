package com.example.training.web.domain.member.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

/**
 * 会員ログインフォームのクラス
 */
@Data
public class MemberLoginForm {

  /**
   * 会員Eメールアドレス
   */
  @NotEmpty
  @Email
  private String email;

  /**
   * 会員パスワード
   */
  @NotEmpty
  private String password;

}

package com.example.training.web.controller.member;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;

/**
 * 会員ログインフォームのクラス
 */
@Getter
public class MemberLoginQuery {

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

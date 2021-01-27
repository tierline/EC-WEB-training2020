package com.example.training.web.domain.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Getter;

/**
 * パスワード（ハッシュ値）の値オブジェクト
 */
public class DigestPassword {

  @Autowired
  private PasswordEncoder passwordEncoder;

  /**
   * パスワードの値
   */
  @Getter
  public String value;

  /**
   * 基本コンストラクタ 平文のパスワードをハッシュ値に変換する。
   *
   * @param digestPassword 平文のパスワード
   */
  public DigestPassword(String plainPassword) {
    if (plainPassword == null) {
      throw new NullPointerException();
    }
    String digestPassword = passwordEncoder.encode(plainPassword);

    this.value = digestPassword;
  }

  /**
   * デフォルトコンストラクタ
   */
  public DigestPassword() {
  }

}

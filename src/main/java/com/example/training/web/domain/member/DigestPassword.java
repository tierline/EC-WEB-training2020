package com.example.training.web.domain.member;

import lombok.Getter;

/**
 * パスワード（ハッシュ値）の値オブジェクト
 */
public class DigestPassword {

  /**
   * パスワードの値
   */
  @Getter
  private String value;

  // @Service をつけてみても、null になる。値オブジェクト内で暗号化すべきか？ するとしたら、どうするか。
  // @Autowired
  // private PasswordEncoder passwordEncoder;

  /**
   * 基本コンストラクタ。平文のパスワードをハッシュ値に変換する。
   *
   * @param digestPassword 平文のパスワード
   */
  public DigestPassword(String value) {
    if (value == null) {
      throw new NullPointerException();
    }
    this.value = value;
  }

  /**
   * デフォルトコンストラクタ
   */
  public DigestPassword() {
  }

}

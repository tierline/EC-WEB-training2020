package com.example.training.common.http;

import com.example.training.common.domain.Admin;
import com.example.training.common.domain.value.Assertion;

import lombok.Getter;

/**
 * セッションに保存する会員情報のクラス
 */
public class AdminSession {

  /**
   * 会員ID
   */
  @Getter
  private Long id;
  /**
   * Eメール
   */
  @Getter
  private String name;

  /**
   * 基本コンストラクタ
   *
   * @param value
   */
  public AdminSession(Admin admin) {
    Long id = admin.getId();
    String name = admin.getName();
    Assertion.isNull(admin.getId().toString(), admin.getName());

    this.id = id;
    this.name = name;
  }

  /**
   * デフォルトコンストラクタ
   */
  public AdminSession() {

  }

}

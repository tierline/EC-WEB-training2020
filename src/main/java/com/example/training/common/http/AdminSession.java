package com.example.training.common.http;

import com.example.training.common.domain.Admin;
import com.example.training.common.domain.value.Assertion;
import com.example.training.common.domain.value.Name;
import com.example.training.common.domain.value.id.AdminId;

import lombok.Getter;

/**
 * セッションに保存する会員情報のクラス
 */
public class AdminSession {

  /**
   * 会員ID
   */
  @Getter
  private AdminId id;
  /**
   * Eメール
   */
  @Getter
  private Name name;

  /**
   * 基本コンストラクタ
   *
   * @param value
   */
  public AdminSession(Admin admin) {
    AdminId id = admin.getId();
    String name = admin.getName();
    Assertion.isNull(admin.getId().toString(), admin.getName());

    this.id = id;
    this.name = new Name(name);
  }

  /**
   * デフォルトコンストラクタ
   */
  public AdminSession() {

  }

}

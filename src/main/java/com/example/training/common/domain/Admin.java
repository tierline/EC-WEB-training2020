package com.example.training.common.domain;

import com.example.training.common.domain.value.DigestPassword;
import com.example.training.common.domain.value.id.AdminId;
import com.example.training.common.entity.AdminEntity;

import lombok.Data;

/**
 * 管理者のクラス
 */
@Data
public class Admin {
  public static final String SESSION_NAME = "ADMIN";

  /**
   * 管理者ID
   */
  private AdminId id;

  /**
   * 名前
   */
  private String name;

  /**
   * パスワード
   */
  private DigestPassword password;

  /**
   * 権限
   */
  private String roles = "ROLE_USER,ROLE_ADMIN";

  /**
   * DBから取得するためのコンストラクタ
   *
   * @param adminEntity
   */
  public Admin(AdminEntity adminEntity) {
    this.id = new AdminId(adminEntity.getId());
    this.name = adminEntity.getName();
    this.password = new DigestPassword(adminEntity.getPassword());
    this.roles = adminEntity.getRoles();
  }

}

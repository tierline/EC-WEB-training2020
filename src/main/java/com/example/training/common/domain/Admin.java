package com.example.training.common.domain;

import com.example.training.common.domain.value.DigestPassword;
import com.example.training.common.domain.value.Name;
import com.example.training.common.domain.value.Role;
import com.example.training.common.domain.value.id.AdminId;
import com.example.training.common.entity.AdminEntity;

import lombok.Getter;

/**
 * 管理者のクラス
 */
@Getter
public class Admin {
  public static final String SESSION_NAME = "ADMIN";

  /**
   * 管理者ID
   */
  private AdminId id;

  /**
   * 名前
   */
  private Name name;

  /**
   * パスワード
   */
  private DigestPassword password;

  /**
   * 権限
   */
  private Role roles = new Role("ROLE_USER,ROLE_ADMIN");

  /**
   * DBから取得するためのコンストラクタ
   *
   * @param adminEntity
   */
  public Admin(AdminEntity adminEntity) {
    this.id = new AdminId(adminEntity.getId());
    this.name = new Name(adminEntity.getName());
    this.password = new DigestPassword(adminEntity.getPassword());
    this.roles = new Role(adminEntity.getRoles());
  }

}

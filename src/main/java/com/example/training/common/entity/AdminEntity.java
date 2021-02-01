package com.example.training.common.entity;

import lombok.Data;

/**
 * キャスト用エンティティ（DB取得時）
 */
@Data
public class AdminEntity {
  /**
   * 管理者ID
   */
  private Long id;
  /**
   * 管理者名
   */
  private String name;
  /**
   * パスワード
   */
  private String password;
  /**
   * 権限
   */
  private String roles = "ROLE_USER,ROLE_ADMIN";
}

package com.example.training.common.entity;

import lombok.Data;

/**
 * キャスト用エンティティ（DB取得時）
 */
@Data
public class AdminEntity {
  private Long id;
  private String name;
  private String password;
  private String roles = "ROLE_USER,ROLE_ADMIN";
}

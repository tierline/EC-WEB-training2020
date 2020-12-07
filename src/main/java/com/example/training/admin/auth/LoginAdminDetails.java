package com.example.training.admin.auth;

import com.example.training.admin.domain.Admin;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoginAdminDetails extends User {
  private static final long serialVersionUID = 1L;
  // DBより検索したMemberエンティティ
  // アプリケーションから利用されるのでフィールドに定義
  private final Admin admin;

  public LoginAdminDetails(Admin admin, String role) {
    super(admin.getName(), admin.getPassword(), AuthorityUtils.createAuthorityList(role));
    this.admin = admin;
  }
}

package com.example.training.common.http.security;

import java.util.Collection;

import com.example.training.common.domain.Admin;
import com.example.training.common.domain.value.Role;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoginAdminDetails extends User {
  private static final long serialVersionUID = 1L;
  // DBより検索したAdminエンティティ
  // アプリケーションから利用されるのでフィールドに定義
  private Admin admin;

  /**
   * データベースより検索したuserエンティティよりSpring Securityで使用するユーザー認証情報のインスタンスを生成する。
   *
   * @param admin adminエンティティ
   */
  public LoginAdminDetails(Admin admin) {
    super(admin.getName().getValue(), admin.getPassword().getValue(), createRole(admin.getRoles()));
    this.admin = admin;
  }

  public Admin getMember() {
    return admin;
  }

  private static Collection<? extends GrantedAuthority> createRole(Role role) {
    return AuthorityUtils.commaSeparatedStringToAuthorityList(role.getValue());
  }

}

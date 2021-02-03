package com.example.training.common.http.security;

import java.util.Optional;

import com.example.training.common.domain.Admin;
import com.example.training.common.domain.value.Name;
import com.example.training.common.entity.AdminEntity;
import com.example.training.common.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("LoginAdminDetailsService")
public class LoginAdminDetailsService implements UserDetailsService {
  @Autowired
  AdminRepository adminRepository;

  /**
   * メールアドレスで検索したユーザーのuserエンティティをLoginUserDetailsクラスのインスタンスへ変換する
   *
   * @param email 検索するユーザーのメールアドレス
   * @return メールアドレスで検索できたユーザーのユーザー情報
   * @throws UsernameNotFoundException メールアドレスでユーザーが検索できなかった場合にスローする。
   */
  @Transactional(readOnly = true)
  @Override
  public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    assert (name != null);
    Optional<AdminEntity> adminEntity = adminRepository.findByName(new Name(name));
    if (adminEntity.isEmpty()) {
      throw new UsernameNotFoundException("名前で管理人が見つけられませんでした。: " + name);
    }
    Admin admin = new Admin(adminEntity.get());
    return new LoginAdminDetails(admin);
  }
}

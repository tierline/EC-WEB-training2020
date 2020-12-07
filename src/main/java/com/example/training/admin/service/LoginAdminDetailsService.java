package com.example.training.admin.service;

import java.util.Optional;

import com.example.training.admin.auth.LoginAdminDetails;
import com.example.training.admin.domain.Admin;
import com.example.training.admin.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginAdminDetailsService implements UserDetailsService {
  @Autowired
  AdminRepository adminRepository;

  /**
   * 登録情報の取得
   */
  @Override
  public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    Optional<Admin> memberOpt = adminRepository.findByName(name);

    if (memberOpt.isEmpty()) {
      throw new UsernameNotFoundException("email or password");
    }
    String role = "ROLE_ADMIN";

    return new LoginAdminDetails(memberOpt.get(), role);
  }
}

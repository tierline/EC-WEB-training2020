package com.example.training.web.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.training.common.domain.Admin;
import com.example.training.common.entity.AdminEntity;
import com.example.training.common.http.AdminSession;
import com.example.training.common.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * 認証成功時のハンドラ
 *
 * @author T.Harao
 *
 */
@Component
public class AdminSuccessHandler implements AuthenticationSuccessHandler {

  @Autowired
  protected HttpSession session;

  @Autowired
  private AdminRepository adminRepository;

  /**
   * 認証成功時
   */
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {
    // 認証したユーザのemail
    String name = authentication.getName();
    Optional<AdminEntity> adminEntity = adminRepository.findByName(name);
    if (adminEntity.isEmpty()) {
    } else {
      // セッションにユーザ情報を格納する
      Admin admin = new Admin(adminEntity.get());
      AdminSession adminSession = new AdminSession(admin);
      session.setAttribute(Admin.SESSION_NAME, adminSession);
      response.sendRedirect("/admin");
    }
  }

}

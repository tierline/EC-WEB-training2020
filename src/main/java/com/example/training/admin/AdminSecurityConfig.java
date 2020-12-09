package com.example.training.admin;

import com.example.training.admin.auth.LoginAdminDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@Order(1)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

  // アカウント登録時のパスワードエンコードで利用するためDI管理する。
  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Autowired
  @Qualifier("LoginAdminDetailsService")
  private LoginAdminDetailsService service;

  /**
   * セキュリティの対象から外す
   */
  @Override
  public void configure(WebSecurity web) throws Exception {
    // @formatter:off
		web
			.ignoring()
			.mvcMatchers("/static/**", "/webjars/**", "/js/**") // 静的リソースに認証が行われないようにする。
		;
		// @formatter:on
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    // @formatter:off
		http
      .mvcMatcher("/admins/**")
      .authorizeRequests()
        .mvcMatchers("/admins/auth/login").permitAll() // 管理者用ログイン画面は誰でもアクセス可能
				.mvcMatchers("/admins/**").hasRole("ADMIN") // admins以下は ADMINロールを持つ認証ユーザのみアクセスできる。
        .anyRequest()
        .authenticated() // 上記以外は認証ユーザのみアクセスできる
			.and()
			.formLogin()
        .loginPage("/admins/auth/login")
        .loginProcessingUrl("/admins/auth/login")
				.usernameParameter("name")
        .passwordParameter("password")
				.defaultSuccessUrl("/")
			.and()
			.logout()
        .logoutUrl("/admins/logout")
        .logoutSuccessUrl("/")
        .deleteCookies("JSESSINONID")
				.invalidateHttpSession(true) // ログアウト時のセッション破棄を有効化
      .and()
        .csrf()
        .disable()
		;
		// @formatter:on
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
  }

}

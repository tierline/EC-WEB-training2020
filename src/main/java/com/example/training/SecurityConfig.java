package com.example.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  private AuthenticationManager authenticationManager1() {
      // defines first AuthenticationManager
    return authenticationManager;
  }

  @Bean
  private AuthenticationManager authenticationManager2() {
    // defines second AuthenticationManager
    return authenticationManager;
  }

  @Configuration
  @Order(1)
  public static class AdminConfigurationAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
        @Qualifier(authenticationManager1)
        private authManager1;

        @Override
        protected AuthenticationManager authenticationManager() {
            return authManager1;
        }

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
        .logoutUrl("/logout")
        .logoutSuccessUrl("/")
        .deleteCookies("JSESSINONID")
				.invalidateHttpSession(true) // ログアウト時のセッション破棄を有効化
      // .and()
      //   .csrf()
      //   .disable()
		;
		// @formatter:on
    }

    @Configuration
    @Order(2)
    public static class Uri2ApiConfigurationAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
        @Qualifier(authenticationManager2)
        private authManager2;

        @Override
        protected AuthenticationManager authenticationManager() {
            return authManager2;
        }

    protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/URI2/**")
                ...
        }
    }
}

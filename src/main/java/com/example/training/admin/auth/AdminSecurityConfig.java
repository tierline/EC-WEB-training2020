package com.example.training.admin.auth;

import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Order(1)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

  /**
   * セキュリティの対象から外す
   */
  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/static/**", "/webjars/**", "/js/**");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http.sessionManagement().invalidSessionUrl("/auth/login");
    http.authorizeRequests().antMatchers("/auth/login").permitAll().anyRequest().authenticated().and().formLogin()
        .loginProcessingUrl("/auth/login").loginPage("/auth/login").failureUrl("/auth/login?error")
        .defaultSuccessUrl("/", true).usernameParameter("name").passwordParameter("password").and().logout()
        .logoutSuccessUrl("/auth/login");

  }
}

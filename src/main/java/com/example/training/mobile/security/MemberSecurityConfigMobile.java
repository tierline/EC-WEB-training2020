package com.example.training.mobile.security;

import com.example.training.common.http.security.LoginMemberDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@Order(3)
public class MemberSecurityConfigMobile extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("LoginMemberDetailsService")
	private LoginMemberDetailsService service;

	@Autowired
	private MemberSuccessHandlerMobile successHandler;

	@Autowired
	private MemberFailureHandlerMobile failureHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// @formatter:off
 		http.mvcMatcher("/api/**").authorizeRequests()
 		    .antMatchers("/api/member/test", "/api/member/login", "/api/member/applicate").permitAll()
 		    .mvcMatchers("/api/**").hasRole("USER")// USERロールを持っていたら許可
 		    .anyRequest().authenticated() // 上記以外は認証ユーザがアクセスできる
 		    .and().formLogin().loginProcessingUrl("/api/member/login")//formデータのpost先
      	    .usernameParameter("email").passwordParameter("password")
	        .successHandler(successHandler)//成功時
	        .failureHandler(failureHandler)//失敗時
	        .and().logout().logoutUrl("/api/member/logout").logoutSuccessUrl("/")
	        .deleteCookies("JSESSIONID").invalidateHttpSession(true) // ログアウト時のセッション破棄を有効化
	        .and().csrf().disable();
		// @formatter:on
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
	}
}

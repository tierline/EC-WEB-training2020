package com.example.training.mobile.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.example.training.common.http.security.LoginMemberDetailsService;

@Configuration
@EnableWebSecurity
@Order(3)
public class MobileMemberSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("LoginMemberDetailsService")
	private LoginMemberDetailsService service;

	@Autowired
	private MobileMemberSuccessHandler successHandler;

	@Autowired
	private MobileMemberFailureHandler failureHandler;

	@Autowired
	@Qualifier("AuthenticationEntryPoint")
	private AuthenticationEntryPoint authenticationEntryPoint;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
		// sessionが切れた時、ログインページを表示する。

		// @formatter:off
 		http.mvcMatcher("/api/**").authorizeRequests()
 		    .antMatchers("/api/member/login", "/api/member/applicate").permitAll()
 		    .mvcMatchers("/api/**").hasRole("USER")// USERロールを持っていたら許可
 		    .anyRequest().authenticated(); // 上記以外は認証ユーザがアクセスできる
 	
 		http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);//認証されていなかったら呼ばれる
 		
 		http.formLogin().loginProcessingUrl("/api/member/login")//formデータのpost先
      	    .usernameParameter("email").passwordParameter("password")
	        .successHandler(successHandler)//認証成功時
	        .failureHandler(failureHandler)//認証失敗時
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

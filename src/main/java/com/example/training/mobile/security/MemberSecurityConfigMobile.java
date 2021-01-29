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

import com.example.training.common.http.security.LoginMemberDetailsService;

@Configuration
@EnableWebSecurity
@Order(3)
public class MemberSecurityConfigMobile extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("LoginMemberDetailsService")
	private LoginMemberDetailsService service;

	@Autowired
	private MemberSuccessHandlerMobile successHandler;

//	/**
//	 * セキュリティの対象から外す
//	 */
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		// @formatter:off
//		web.ignoring().mvcMatchers("/static/**", "/webjars/**", "/js/**") // 静的リソースに認証が行われないようにする。
//		;
//		// @formatter:on
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// @formatter:off
 		http.mvcMatcher("/api/**").authorizeRequests()
 		    .antMatchers("/api/member/login", "/api/member/applicate").permitAll()
 		    .mvcMatchers("/api/**").hasRole("USER")// USERロールを持っていたら許可
 		    .anyRequest().authenticated() // 上記以外は認証ユーザがアクセスできる
 		    .and().formLogin().loginProcessingUrl("/api/member/login")
      	    .usernameParameter("email").passwordParameter("password")
	        .successHandler(successHandler).and().logout().logoutUrl("/api/member/logout")
	        .deleteCookies("JSESSIONID").invalidateHttpSession(true) // ログアウト時のセッション破棄を有効化
	        .and().csrf().disable();
		// @formatter:on
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
	}

}

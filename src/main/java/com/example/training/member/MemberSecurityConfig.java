package com.example.training.member;

import com.example.training.SuccessHandler;
import com.example.training.member.auth.LoginMemberDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@Order(2)
public class MemberSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("LoginMemberDetailsService")
	private LoginMemberDetailsService service;

	@Autowired
	private SuccessHandler successHandler;

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
			.mvcMatcher("/members/**")
			.authorizeRequests()
				.mvcMatchers("/members/auth/login").permitAll()
				.mvcMatchers("/members/**").hasRole("USER")	// members以下は USERロールを持つ認証ユーザのみアクセスできる。
				.anyRequest()
				.authenticated() // 上記以外は認証ユーザがアクセスできる
			.and()
			.formLogin()
				.loginPage("/members/auth/login")
				.loginProcessingUrl("/members/auth/login")
				.usernameParameter("email")
        .passwordParameter("password")
				.defaultSuccessUrl("/")
				.successHandler(successHandler)
			.and()
			.logout()
			  .logoutUrl("/members/logout")
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

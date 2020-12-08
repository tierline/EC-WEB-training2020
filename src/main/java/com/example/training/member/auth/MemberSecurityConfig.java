package com.example.training.member.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Order(2)
public class MemberSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * セキュリティの対象から外す
	 */
	// @Override
	// public void configure(WebSecurity web) throws Exception {
	// web.ignoring().antMatchers("/static/**", "/webjars/**", "/js/**");
	// }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().invalidSessionUrl("/members/auth/login");
		http.authorizeRequests().antMatchers("members/auth/login").permitAll().anyRequest().authenticated();
		http.formLogin().loginPage("/members/auth/login").usernameParameter("email").passwordParameter("password")
				.defaultSuccessUrl("/", true).and().logout().logoutSuccessUrl("/members/auth/login");

		// http.authorizeRequests().antMatchers("/members/auth/login").permitAll().anyRequest().authenticated().and()
		// .formLogin().loginProcessingUrl("/members/auth/login").loginPage("/members/auth/login")
		// .failureUrl("/members/auth/login?error").defaultSuccessUrl("/",
		// true).usernameParameter("abc@example.com")
		// .passwordParameter("1234").and().logout().logoutSuccessUrl("/members/auth/login");
	}
}

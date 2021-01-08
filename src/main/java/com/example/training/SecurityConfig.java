package com.example.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * セキュリティの対象から外す
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/static/**", "/webjars/**", "/js/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll();
		/*
		 * http.csrf().disable();
		 * http.sessionManagement().invalidSessionUrl("/auth/login");
		 * http.authorizeRequests().antMatchers("/auth/login").permitAll().anyRequest().
		 * authenticated().and().formLogin()
		 * .loginProcessingUrl("/auth/login").loginPage("/auth/login").failureUrl(
		 * "/auth/login?error") .defaultSuccessUrl("/",
		 * true).usernameParameter("name").passwordParameter("password").and().logout()
		 * .logoutSuccessUrl("/auth/login");
		 */

	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}

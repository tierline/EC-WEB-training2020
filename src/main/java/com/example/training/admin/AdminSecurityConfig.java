// package com.example.training.admin;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.annotation.Order;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.builders.WebSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// @Configuration
// @EnableWebSecurity
// @Order(1)
// public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

// // アカウント登録時のパスワードエンコードで利用するためDI管理する。
// // @Bean
// // PasswordEncoder passwordEncoder() {
// // return new BCryptPasswordEncoder();
// // }

// /**
// * セキュリティの対象から外す
// */
// @Override
// public void configure(WebSecurity web) throws Exception {
//     // @formatter:off
// 		web
// 			.ignoring()
// 			.mvcMatchers("/static/**", "/webjars/**", "/js/**") // 静的リソースに認証が行われないようにする。
// 		;
// 		// @formatter:on
// }

// @Override
// protected void configure(HttpSecurity http) throws Exception {

//     // @formatter:off
// 		http
// 			// .csrf().disable() // csrfを無効化
// 			.authorizeRequests()
// 				.mvcMatchers("/", "/singup").permitAll()	// トップと登録画面は誰でもアクセスできる。
// 				.mvcMatchers("/members/**").hasRole("USER")	// members以下は USERロールを持つ認証ユーザのみアクセスできる。
// 				.mvcMatchers("/admins/**", "/cart/list").hasRole("ADMIN") // admins以下は ADMINロールを持つ認証ユーザのみアクセスできる。
// 				.anyRequest().authenticated() // 上記以外は認証ユーザがアクセスできる
// 			.and()
// 			.formLogin()
// 				.defaultSuccessUrl("/")
// 			.and()
// 			.logout()
// 				.invalidateHttpSession(true) // ログアウト時のセッション破棄を有効化
// 				.deleteCookies("JSESSINONID")
// 				.logoutSuccessUrl("/login")
// 		;
// 		// @formatter:on
// }

// }

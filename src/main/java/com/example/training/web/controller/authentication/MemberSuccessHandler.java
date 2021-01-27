package com.example.training.web.controller.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.training.common.repository.MemberRepository;
import com.example.training.web.domain.member.Email;
import com.example.training.web.domain.member.Member;
import com.example.training.web.domain.member.MemberSession;

@Component
public class MemberSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	protected HttpSession session;

	@Autowired
	private MemberRepository memberRepository;

	/**
	 * 認証成功時
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String name = authentication.getName();
		Email email = new Email(name);
		MemberSession memberSession = memberRepository.findByEmailSession(email).orElseThrow();
		session.setAttribute(Member.SESSION_NAME, memberSession);

//		String email = authentication.getName();
//		MemberEntity entity = memberRepository.findByEmail(email).orElseThrow();
//		Member member = new Member(entity);
//		session.setAttribute(Member.SESSION_NAME, member);

		response.sendRedirect("/");
	}
}

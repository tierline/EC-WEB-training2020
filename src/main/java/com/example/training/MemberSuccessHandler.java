package com.example.training;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.training.member.MemberEntity;
import com.example.training.member.domain.Member;
import com.example.training.member.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

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
		String email = authentication.getName();
		MemberEntity entity = memberRepository.findByEmailMember(email).orElseThrow();
		Member member = new Member(entity);
		session.setAttribute(Member.SESSION_NAME, member);
		response.sendRedirect("/");
	}
}

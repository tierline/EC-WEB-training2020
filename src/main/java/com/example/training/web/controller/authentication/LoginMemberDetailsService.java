package com.example.training.web.controller.authentication;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.training.common.repository.MemberRepository;
import com.example.training.web.domain.member.Email;
import com.example.training.web.domain.member.Member;
import com.example.training.web.domain.member.MemberEntity;

@Component("LoginMemberDetailsService")
public class LoginMemberDetailsService implements UserDetailsService {
	@Autowired
	private MemberRepository memberRepository;

	/**
	 * メールアドレスで検索したユーザーのuserエンティティをLoginUserDetailsクラスのインスタンスへ変換する
	 *
	 * @param email 検索するユーザーのメールアドレス
	 * @return メールアドレスで検索できたユーザーのユーザー情報
	 * @throws UsernameNotFoundException メールアドレスでユーザーが検索できなかった場合にスローする。
	 */
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		assert (name != null);
		Email email = new Email(name);
		Optional<MemberEntity> memberOpt = memberRepository.findByEmail(email);
		if (memberOpt.isEmpty()) {
			throw new UsernameNotFoundException("User not found for email: " + email);
		} else {
			Member member = new Member(memberOpt.get());
			if (member.getStatus().equals("unapproved")) {
				throw new UsernameNotFoundException("Unauthorized user.: " + email);
			} else {
				return new LoginMemberDetails(member);
			}
		}
	}
}

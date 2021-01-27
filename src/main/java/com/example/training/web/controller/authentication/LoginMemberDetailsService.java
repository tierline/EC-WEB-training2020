package com.example.training.web.controller.authentication;

import java.util.Optional;

<<<<<<< HEAD
=======
import com.example.training.common.repository.MemberRepository;
import com.example.training.web.domain.member.Email;
import com.example.training.web.domain.member.Member;
import com.example.training.web.domain.member.MemberEntity;

>>>>>>> origin/kato
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
<<<<<<< HEAD
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		assert (name != null);
		Email email = new Email(name);
		Optional<MemberEntity> memberOpt = memberRepository.findByEmail(email);
		if (memberOpt.isEmpty()) {
			throw new UsernameNotFoundException("User not found for email: " + email);
		} else {
			Member member = new Member(memberOpt.get());
			if (member.getStatus().equals("UNAPPROVED")) {
				throw new UsernameNotFoundException("Unauthorized user.: " + email);
=======
	public UserDetails loadUserByUsername(String stringEmail) throws UsernameNotFoundException {
		Email email = new Email(stringEmail);
		Optional<MemberEntity> memberEntityOpt = memberRepository.findByEmail(email);
		if (memberEntityOpt.isEmpty()) {
			throw new UsernameNotFoundException("Eメールで会員が見つけられませんでした。: " + email);
		} else {
			Member member = new Member(memberEntityOpt.get());
			if (member.getStatus().equals("unapproved")) {
				throw new UsernameNotFoundException("承認されていない会員です。: " + email);
>>>>>>> origin/kato
			} else {
				return new LoginMemberDetails(member);
			}
		}
	}
}

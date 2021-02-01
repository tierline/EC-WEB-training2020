package com.example.training.common.http.security;

import com.example.training.common.domain.Member;
import com.example.training.common.domain.value.Email;
import com.example.training.common.entity.MemberEntity;
import com.example.training.common.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
	public UserDetails loadUserByUsername(String stringEmail) throws UsernameNotFoundException {
		Email email = new Email(stringEmail);
		MemberEntity entity = memberRepository.findByEmail(email).orElseThrow();
		// TODO 新規登録>ログイン>DBに名前、住所等のデータがないため承認されていてもここで止まる
		Member member = new Member(entity);
		if (member.getStatus().equals("unapproved")) {
			throw new UsernameNotFoundException("承認されていない会員です。: " + email);
		}
		return new LoginMemberDetails(member);
	}
}

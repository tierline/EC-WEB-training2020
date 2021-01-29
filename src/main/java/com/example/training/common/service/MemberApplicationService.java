package com.example.training.common.service;

import com.example.training.common.domain.Member;
import com.example.training.common.domain.value.DigestPassword;
import com.example.training.common.repository.MemberRepository;
import com.example.training.web.controller.member.MemberApplicationCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 会員新規作成のドメインサービス
 */
@Service
public class MemberApplicationService {

	// fix DigestPasswordオブジェクトの中でエンコードする方法に失敗している状態。
	// ServiceからServiceを呼んでいいのか。
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private MemberRepository memberRepository;

	/**
	 * 会員を新規作成する。
	 *
	 * @param memberApplicationCommand 会員作成フォーム
	 */
	@Transactional
	public void run(MemberApplicationCommand memberApplicationCommand) {
		String rawPassword = memberApplicationCommand.getPassword().toString();
		String digestPasswordString = passwordEncoder.encode(rawPassword);
		DigestPassword digestPassword = new DigestPassword(digestPasswordString);
		Member member = memberApplicationCommand.createMember(digestPassword);
		memberRepository.save(member);
	}
}

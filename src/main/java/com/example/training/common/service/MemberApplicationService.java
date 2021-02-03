package com.example.training.common.service;

import com.example.training.common.domain.Member;
import com.example.training.common.domain.value.DigestPassword;
import com.example.training.common.repository.MemberRepository;
import com.example.training.web.controller.member.MemberApplicationCommand;
import com.example.training.web.controller.service.DigestPasswordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 会員新規作成のドメインサービス
 */
@Service
public class MemberApplicationService {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private DigestPasswordService digestPasswordService;

	/**
	 * 会員を新規作成する。
	 *
	 * @param command 会員作成フォーム
	 */
	@Transactional
	public void run(MemberApplicationCommand command) {
		String rawPassword = command.getPassword().toString();
		DigestPassword password = digestPasswordService.generate(rawPassword);
		Member member = command.createMember(password);
		memberRepository.save(member);
	}
}

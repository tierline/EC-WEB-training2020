
package com.example.training.web.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.training.common.repository.MemberRepository;
import com.example.training.web.domain.member.DigestPassword;
import com.example.training.web.domain.member.Member;
import com.example.training.web.domain.member.form.MemberApplicationForm;

@Service
public class MemberApplicationService {

	// fix DigestPasswordオブジェクトの中でエンコードする方法に失敗している状態。
	// ServiceからServiceを呼んでいいのか。
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private MemberRepository memberRepository;

	@Transactional
	public void run(MemberApplicationForm memberApplicationForm) {
		String rawPassword = memberApplicationForm.getPassword();
		String digestPasswordString = passwordEncoder.encode(rawPassword);
		DigestPassword digestPassword = new DigestPassword(digestPasswordString);
		Member member = memberApplicationForm.createMember(digestPassword);
		memberRepository.create(member);
	}
}

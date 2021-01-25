
package com.example.training.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.training.common.repository.MemberRepository;
import com.example.training.domain.member.DigestPassword;
import com.example.training.domain.member.Email;
import com.example.training.domain.member.Member;
import com.example.training.domain.member.MemberApplicationForm;
import com.example.training.domain.member.RawPassword;

@Service
public class MemberApplicationService {
//  @Autowired
//  private PasswordEncoder passwordEncoder;

	@Autowired
	private MemberRepository memberRepository;

	/*
	 * データベースへの新規登録
	 */
	@Transactional
	public void run(MemberApplicationForm memberApplicationForm) {
		Email email = new Email(memberApplicationForm.getEmail());
		RawPassword rawPassword = new RawPassword(memberApplicationForm.getPassword());
		DigestPassword passwordDigest = new DigestPassword(rawPassword);
		Member member = new Member(email, passwordDigest);
		memberRepository.insert(member);

	}

	/*
	 * 既に存在するかの確認
	 */
//	private Boolean exists(Email email) {
//		Optional<MemberEntity> member = memberRepository.findByEmail(email);
//		if (member.isEmpty()) {
//			return true;
//		}
//		return false;
//	}
}

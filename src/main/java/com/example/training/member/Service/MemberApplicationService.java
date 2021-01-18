package com.example.training.member.service;

import com.example.training.member.domain.Member;
import com.example.training.member.domain.MemberApplicationForm;
import com.example.training.member.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberApplicationService {
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private MemberRepository memberRepository;

  /**
   *
   * 会員の新規会員登録をする
   *
   * @param memberApplicationForm
   */
  @Transactional
  public void run(MemberApplicationForm memberApplicationForm) {
    String password = memberApplicationForm.getPassword();
    String passwordDigest = passwordEncoder.encode(password);
    Member member = memberApplicationForm.createMember(passwordDigest);
    memberRepository.create(member);
  }

}

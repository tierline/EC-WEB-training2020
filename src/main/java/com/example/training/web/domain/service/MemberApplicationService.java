
package com.example.training.web.domain.service;

import com.example.training.common.repository.MemberRepository;
import com.example.training.web.domain.member.DigestPassword;
import com.example.training.web.domain.member.Member;
import com.example.training.web.domain.member.form.MemberApplicationForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberApplicationService {

  // 本来は不要
  // mobile版で DigestPassword 型を使うように修正したら削除する予定。
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private MemberRepository memberRepository;

  @Transactional
  public void run(MemberApplicationForm memberApplicationForm) {
    String plainPassword = memberApplicationForm.getPassword();
    DigestPassword digestPassword = new DigestPassword(plainPassword);
    Member member = memberApplicationForm.createMember(digestPassword);
    memberRepository.create(member);
  }
}

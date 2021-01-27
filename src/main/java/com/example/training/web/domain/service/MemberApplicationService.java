
package com.example.training.web.domain.service;

import com.example.training.common.repository.MemberRepository;
import com.example.training.web.domain.member.Member;
import com.example.training.web.domain.member.MemberApplicationForm;

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

  @Transactional
  public void run(MemberApplicationForm memberApplicationForm) {
    String password = memberApplicationForm.getPassword();
    String passwordDigest = passwordEncoder.encode(password);
    Member member = memberApplicationForm.createMember(passwordDigest);
    memberRepository.create(member);
  }
}

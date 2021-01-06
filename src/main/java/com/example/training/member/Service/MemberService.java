package com.example.training.member.Service;

import com.example.training.member.domain.MemberApplicateForm;
import com.example.training.member.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private MemberRepository memberRepository;

  @Transactional
  public void create(MemberApplicateForm memberApplicateForm) {
    String password = memberApplicateForm.getPassword();
    String digest = passwordEncoder.encode(password);
    memberRepository.create(memberApplicateForm, digest);
  }

}

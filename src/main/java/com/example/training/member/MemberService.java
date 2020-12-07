package com.example.training.member;

import com.example.training.member.domain.Member;
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
  public void create(Member member) {
    String password = member.getPassword();
    String digest = passwordEncoder.encode(password);

    // Map<Member, String> param = new HashMap<>();
    // param.put("member", member);
    // param.put("digest", digest);
    memberRepository.create(member, digest);
  }

}

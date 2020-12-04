package com.example.training.member;

import com.example.training.member.domain.Member;
import com.example.training.member.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

  @Autowired
  private MemberRepository memberRepository;

  @Transactional
  public void create(Member member) {
    memberRepository.create(member);
  }

}

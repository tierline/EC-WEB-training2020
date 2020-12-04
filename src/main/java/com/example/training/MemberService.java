package com.example.training;

import com.example.training.domain.Member;
import com.example.training.repository.MemberRepository;

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

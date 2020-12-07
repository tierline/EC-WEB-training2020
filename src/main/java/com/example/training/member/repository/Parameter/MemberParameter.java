package com.example.training.member.repository.Parameter;

import com.example.training.member.domain.Member;

import lombok.Data;

@Data
public class MemberParameter {

  private Member member;
  private String digest;

  public MemberParameter(Member member, String digest) {
    this.member = member;
    this.digest = digest;
  }
}

package com.example.training.restApi.member.auth;

import java.util.Optional;

import com.example.training.member.Service.MemberService;
import com.example.training.member.domain.Member;
import com.example.training.member.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/member")
public class ApiMembersAuthConntroller {

  @Autowired
  private MemberService memberService;

  @Autowired
  private MemberRepository memberRepository;

  @PostMapping("/applicate")
  @ResponseBody
  public Member create(@RequestBody Member member) {
    memberService.create(member);
    return member;
  }

  @PostMapping("/login")
  @ResponseBody
  public Boolean login(@RequestBody Member member) {
    Optional<Member> memberDetail = memberRepository.findByEmail(member.getEmail());
    if (memberDetail.isPresent()) {
      return true;
    }
    return false;
  }

}

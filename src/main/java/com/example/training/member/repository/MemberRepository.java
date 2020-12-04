package com.example.training.member.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.training.member.domain.Member;

@Mapper
public interface MemberRepository {

	Optional<Member> findByEmail(String email);

	public List<Member> findAll();

	public void create(Member member);
}

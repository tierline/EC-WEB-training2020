package com.example.training.repository;

import java.util.Optional;

import com.example.training.domain.Member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {

	Optional<Member> findByEmail(String email);

	public void save(Member member);
}

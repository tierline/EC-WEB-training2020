package com.example.training.member.repository;

import java.util.List;
import java.util.Optional;

import com.example.training.member.domain.Member;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberRepository {

	Optional<Member> findByEmail(String email);

	public List<Member> findAll();

	public void create(@Param("member") Member member, @Param("digest") String digest);
	// public void create(Map<Member, String> parm);
}

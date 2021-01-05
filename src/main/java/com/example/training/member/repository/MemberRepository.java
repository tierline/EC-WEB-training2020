package com.example.training.member.repository;

import java.util.List;
import java.util.Optional;

import com.example.training.common.domain.OrderForm;
import com.example.training.member.domain.Member;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberRepository {

	public Optional<Member> findByEmail(String email);

	public Member findById(int id);

	public List<Member> findAll();

	public void create(@Param("member") Member member, @Param("digest") String digest);

	public void update(@Param("member") Member member, @Param("digest") String digest,
			@Param("lastUpdatedBy") String lastUpdatedBy);

	public void updateAtOrder(@Param("orderForm") OrderForm orderForm);

}

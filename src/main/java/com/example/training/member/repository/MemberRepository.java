package com.example.training.member.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.training.common.domain.OrderForm;
import com.example.training.member.domain.Member;
import com.example.training.member.domain.MemberEditForm;

@Mapper
public interface MemberRepository {

	public Optional<Member> findByEmail(String email);

	public Member findById(int id);

	public List<Member> findAll();

	public void create(@Param("newMember") Member member, @Param("digest") String digest);

	public int countByEmail(String email);

	public void update(@Param("memberEditForm") MemberEditForm memberEditForm,
			@Param("lastUpdatedBy") String lastUpdatedBy);

	public Member findAddress(String email);

	public void updateAtOrder(@Param("orderForm") OrderForm orderForm);

}

package com.example.training.member.repository;

import java.util.List;
import java.util.Optional;

import com.example.training.common.domain.order.OrderForm;
import com.example.training.member.MemberEntity;
import com.example.training.member.domain.Member;
import com.example.training.member.domain.MemberEditForm;
import com.example.training.member.domain.MemberId;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberRepository {
	public Optional<MemberEntity> findByEmailMember(String email);

	public Optional<Member> findByEmail(String email);

	public MemberEntity findById(MemberId memberId);

	public List<MemberEntity> findAll();

	public void create(Member member);

	public void update(@Param("memberEditForm") MemberEditForm memberEditForm,
			@Param("lastUpdatedBy") String lastUpdatedBy);// formを引数にとらない

	public Member findAddress(String email);

	public void updateAtOrder(@Param("orderForm") OrderForm orderForm);// formを引数にとらない

	// public Member findByEmailSample(@Param("email") String email);

}

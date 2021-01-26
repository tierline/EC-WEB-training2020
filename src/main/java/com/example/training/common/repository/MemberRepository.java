package com.example.training.common.repository;

import java.util.List;
import java.util.Optional;

import com.example.training.web.domain.member.Member;
import com.example.training.web.domain.member.MemberEditForm;
import com.example.training.web.domain.member.MemberEntity;
import com.example.training.web.domain.member.MemberId;
import com.example.training.web.domain.order.OrderForm;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberRepository {
	public Optional<MemberEntity> findByEmail(String email);

	public MemberEntity findById(MemberId memberId);

	public List<MemberEntity> findAll();

	public void create(Member member);

	public void update(@Param("memberEditForm") MemberEditForm memberEditForm,
			@Param("lastUpdatedBy") String lastUpdatedBy);// formを引数にとらない

	public Member findAddress(String email);

	public void updateAtOrder(@Param("orderForm") OrderForm orderForm);// formを引数にとらない

}

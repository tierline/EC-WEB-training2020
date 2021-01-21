package com.example.training.member.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.training.common.domain.order.OrderForm;
import com.example.training.member.MemberEntity;
import com.example.training.member.domain.Member;
import com.example.training.member.domain.MemberId;
import com.example.training.member.domain.form.MemberEditForm;

@Mapper
public interface MemberRepository {
	public Optional<MemberEntity> findByEmailMember(String email);

	public Optional<Member> findByEmail(String email);

	public Member findById(MemberId id);

	public List<Member> findAll();

	public void create(Member member);

	public int countByEmail(String email);

	public void update(@Param("memberEditForm") MemberEditForm memberEditForm,
			@Param("lastUpdatedBy") String lastUpdatedBy);

	public Member findAddress(String email);

	public void updateAtOrder(@Param("orderForm") OrderForm orderForm);

	public Member findByEmailSample(@Param("email") String email);

}

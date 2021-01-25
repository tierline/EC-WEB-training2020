package com.example.training.member.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.training.common.domain.order.OrderForm;
import com.example.training.domain.Email;
import com.example.training.domain.MemberId;
import com.example.training.domain.service.MemberSession;
import com.example.training.member.MemberEntity;
import com.example.training.member.domain.Member;
import com.example.training.member.domain.MemberEditForm;

@Mapper
public interface MemberRepository {
	// insertMember
	// upDateMember(Member member)
	// emailはEmail
//	public Optional<MemberEntity> findByEmailMember(Email email);

	public Optional<MemberEntity> findByEmail(Email email);

	public Optional<MemberSession> findByEmailSession(Email email);

	public MemberEntity findById(MemberId memberId);

	public List<MemberEntity> findAll();

	public void insert(Member member);

	public int countByEmail(String email);

	public void update();

	public void update(@Param("memberEditForm") MemberEditForm memberEditForm,
			@Param("lastUpdatedBy") String lastUpdatedBy);// formを引数にとらない

	public Member findAddress(String email);

	public void updateAtOrder(@Param("orderForm") OrderForm orderForm);// formを引数にとらない

	// public Member findByEmailSample(@Param("email") String email);

}

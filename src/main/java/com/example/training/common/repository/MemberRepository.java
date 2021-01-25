package com.example.training.common.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.training.domain.MemberEntity;
import com.example.training.domain.MemberSession;
import com.example.training.domain.member.Email;
import com.example.training.domain.member.Member;
import com.example.training.domain.member.MemberEditForm;
import com.example.training.domain.member.MemberId;
import com.example.training.domain.order.OrderForm;

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

package com.example.training.common.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.training.web.domain.MemberEntity;
import com.example.training.web.domain.MemberSession;
import com.example.training.web.domain.member.Email;
import com.example.training.web.domain.member.Member;
import com.example.training.web.domain.member.MemberEditForm;
import com.example.training.web.domain.member.MemberId;

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

	public void create(Member member);

	public void updateAtOrder(Member member);// formを引数にとらない

	public int countByEmail(String email);

	public void update(Member member);

	public void update(@Param("memberEditForm") MemberEditForm memberEditForm,
			@Param("lastUpdatedBy") String lastUpdatedBy);// formを引数にとらない

	public Member findAddress(String email);

	// public Member findByEmailSample(@Param("email") String email);

}

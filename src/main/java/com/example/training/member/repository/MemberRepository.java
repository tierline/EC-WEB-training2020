package com.example.training.member.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.training.member.MemberEntity;
import com.example.training.member.domain.Member;
import com.example.training.member.domain.MemberId;

@Mapper
public interface MemberRepository {
	// insertMember
	// upDateMember(Member member)
	// emailはEmail
	public Optional<MemberEntity> findByEmailMember(String email);

	public Optional<Member> findByEmail(String email);

	public MemberEntity findById(MemberId memberId);

	public List<MemberEntity> findAll();

	public void create(Member member);

	public int countByEmail(String email);

	public void update();

	public Member findAddress(String email);

	// formがでてくるのが違和感
	public void updateAtOrder();

	public Member findByEmailSample(@Param("email") String email);

}

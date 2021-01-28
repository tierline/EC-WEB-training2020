package com.example.training.common.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.training.web.domain.member.Email;
import com.example.training.web.domain.member.Member;
import com.example.training.web.domain.member.MemberEntity;
import com.example.training.web.domain.member.MemberId;
import com.example.training.web.domain.member.form.MemberEditForm;

/**
 * 会員のリポジトリー
 */
@Mapper
public interface MemberRepository {

	/**
	 * Eメールで取得する。
	 */
	public Optional<MemberEntity> findByEmail(Email email);

	/**
	 * IDで取得する。
	 */
	public MemberEntity findById(MemberId memberId);

	/**
	 * 全ての会員を取得する。
	 */
	public List<MemberEntity> findAll();

	/**
	 * 会員を作る。
	 *
	 * @param member
	 */
	public void create(Member member);

	/**
	 * 会員情報を更新する。
	 *
	 * @param memberEditForm
	 * @param lastUpdatedBy
	 */
	public void update(@Param("memberEditForm") MemberEditForm memberEditForm,
			@Param("lastUpdatedBy") String lastUpdatedBy);// formを引数にとらない

	public void updateAtOrder(Member member);// formを引数にとらない

}

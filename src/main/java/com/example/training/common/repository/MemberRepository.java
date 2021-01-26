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

/**
 * 会員のリポジトリー
 */
@Mapper
public interface MemberRepository {

	/**
	 * Eメールで取得する。
	 */
	public Optional<MemberEntity> findByEmail(String email);

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

	public void updateAtOrder(@Param("orderForm") OrderForm orderForm);// formを引数にとらない

}

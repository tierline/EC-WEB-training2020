package com.example.training.common.repository;

import java.util.List;
import java.util.Optional;

import com.example.training.common.domain.Member;
import com.example.training.common.domain.value.Email;
import com.example.training.common.domain.value.id.MemberId;
import com.example.training.common.entity.MemberEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 会員のリポジトリ
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
	public Optional<MemberEntity> findById(MemberId memberId);

	/**
	 * 全ての会員を取得する。
	 */
	public List<MemberEntity> findAll();

	/**
	 * 会員を生成する。
	 *
	 * @param member
	 */
	public void save(Member member);

	/**
	 * フォーム内容で会員情報を更新する。
	 *
	 * @param memberEditCommand
	 * @param lastUpdate
	 */
	public void updateByAdmin(Member member);

	/**
	 * 注文内容で会員情報を更新する。
	 *
	 * @param member 会員
	 */
	public void updateAtOrder(Member member);

}

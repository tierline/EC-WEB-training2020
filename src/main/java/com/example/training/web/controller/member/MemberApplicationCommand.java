package com.example.training.web.controller.member;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.example.training.common.domain.Member;
import com.example.training.common.domain.value.DigestPassword;
import com.example.training.common.domain.value.Email;
import com.example.training.common.domain.value.MemberStatus;

import lombok.Data;

/**
 * 会員新規登録フォームのクラス
 */

@Data
public class MemberApplicationCommand {

	/**
	 * Eメール
	 */
	private String email;

	/**
	 * パスワード
	 */
	@NotEmpty
	@Size(max = 16, message = "パスワードは16文字以内で入力してください")
	private String password;

	/**
	 * 新規会員登録用のMemberを生成する。
	 *
	 * @param passwordDigest
	 * @return 会員登録用のメンバーオブジェクト
	 */
	public Member createMember(DigestPassword password) {
		return new Member(this, password);
	}

	/*
	 * mobile版の新規登録用のMemberを作る
	 *
	 */
	public Member createMember(DigestPassword password, MemberStatus status) {
		return new Member(this, password, status);
	}

	public Email createEmail() {
		return new Email(this.email);
	}

}

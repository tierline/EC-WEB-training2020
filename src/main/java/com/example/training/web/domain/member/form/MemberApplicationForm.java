package com.example.training.web.domain.member.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.example.training.web.domain.member.DigestPassword;
import com.example.training.web.domain.member.Member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 会員新規登録フォームのクラス
 */
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class MemberApplicationForm {

	/**
	 * fix: 型をつける Eメール
	 */
	private String email;

	/**
	 * パスワード
	 */
	@NotEmpty
	@Size(max = 16, message = "パスワードは16文字以内で入力してください")
	private String password;

	/**
	 *
	 * 新規会員登録用のMemberを作る。
	 *
	 * @param passwordDigest
	 * @return 会員登録用のメンバーオブジェクト
	 */
	public Member createMember(DigestPassword digestPassword) {
		return new Member(this, digestPassword);
	}

}

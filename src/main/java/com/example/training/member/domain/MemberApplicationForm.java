package com.example.training.member.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.example.training.domain.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class MemberApplicationForm {

	private String email;

	@NotEmpty
	@Size(max = 16, message = "パスワードは16文字以内で入力してください")
	private String password;

	/**
	 *
	 * 新規会員登録用のMemberを作成する
	 *
	 * @param passwordDigest
	 * @return 会員登録用のメンバーオブジェクト
	 */
	public Member createMember(Email email, DigestPassword passwordDigest) {
		return new Member(email, passwordDigest);
	}

}

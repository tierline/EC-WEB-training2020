package com.example.training.web.domain.member;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

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
	public Member createMember(Email email, DigestPassword digestPassword) {
		return new Member(email, digestPassword);
	}

	public String getEmail() {
		return this.email;
	}

}

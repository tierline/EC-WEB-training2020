package com.example.training.web.controller.member;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 会員情報編集フォームのクラス
 */
@Data
public class MemberEditForm {

	/**
	 * 会員ID
	 */
	@NotEmpty
	private Long memberId;

	/**
	 * 会員Eメールアドレス
	 */
	@NotEmpty
	@Email
	@Size(min = 1, max = 128, message = "メールアドレスは1文字以上、128文字以内で入力してください")
	private String email;

	/**
	 * 会員の承認状態
	 */
	@NotEmpty
	private String status;

}

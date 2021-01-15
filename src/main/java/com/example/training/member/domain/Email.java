package com.example.training.member.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Email {
	// TOREVIEW 値オブジェクトを作りたい
	@NotEmpty
	@Size(min = 1, max = 128, message = "メールアドレスは1文字以上、128文字以内で入力してください")
	private String email;

}

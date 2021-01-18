package com.example.training.member.domain;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Email {

	@Size(min = 1, max = 128, message = "メールアドレスは1文字以上、128文字以内で入力してください")
	@Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "Eメールの形式が間違っています")
	private String email;

}

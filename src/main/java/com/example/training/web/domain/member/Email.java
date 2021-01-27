package com.example.training.web.domain.member;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Email {

	@Size(min = 1, max = 128, message = "メールアドレスは1文字以上、128文字以内で入力してください")
	@Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "Eメールの形式が間違っています")
	private String value;

	public Email(String value) {
		this.value = value;
	}

	public Email() {

	}

	public String getValue() {
		return this.value;
	}

	public Email getEmail() {
		return new Email(this.value);
	}

//	public static Email doTypeConverting(String email) {
//		return new Email(email);
//	}

}

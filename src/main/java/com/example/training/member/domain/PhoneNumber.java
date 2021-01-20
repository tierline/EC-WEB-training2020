package com.example.training.member.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class PhoneNumber {

	@NotEmpty
	@Size(min = 10, max = 11, message = "電話番号は10桁〜11桁の間で入力してください")
	@Pattern(regexp = "[0-9]*", message = "電話番号の形式が間違っています")
	private String phoneNumber;

	public PhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PhoneNumber() {

	}

}

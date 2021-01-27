package com.example.training.web.domain.member;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneNumber {

		private String value;

	public PhoneNumber(String value) {
		//if()
		this.value = value;
	}

	public PhoneNumber() {

	}

}

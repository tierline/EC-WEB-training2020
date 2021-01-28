package com.example.training.web.domain.member;

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

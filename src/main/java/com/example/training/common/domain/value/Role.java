package com.example.training.common.domain.value;

import lombok.Getter;

public class Role {
	@Getter
	private String value;

	public Role(String value) {
		Assertion.isNull(value);
		this.value = value;
	}

}

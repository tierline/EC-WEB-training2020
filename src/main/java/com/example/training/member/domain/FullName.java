package com.example.training.member.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;

@Getter
public class FullName {

	// formのバリデーションは別で
	@NotEmpty
	@Size(max = 16, min = 1)
	private Name lastName;

	@NotEmpty
	@Size(max = 16, min = 1)
	private Name firstName;

	public FullName(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public FullName() {

	}

	public String getValue() {
		return this.lastName + this.firstName;

	}
}

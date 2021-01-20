package com.example.training.member.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;

@Getter
public class FullName {
	@NotEmpty
	private String fullName;

	@NotEmpty
	@Size(max = 16, min = 1)
	private String lastName;

	@NotEmpty
	@Size(max = 16, min = 1)
	private String firstName;

	public FullName(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public FullName(String fullName) {
		this.fullName = fullName;
	}

	public FullName() {

	}

	public FullName getFullName() {
		String fullName = this.lastName + this.firstName;
		return new FullName(fullName);
	}

}

package com.example.training.member.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class FullName {
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

	public String getFullName() {
		return this.lastName + this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getFirstName() {
		return this.firstName;
	}

}

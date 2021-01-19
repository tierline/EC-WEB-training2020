package com.example.training.member.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class FullName {
	@Size(max = 16)
	@NotEmpty
	private String lastName;

	@Size(max = 16)
	@NotEmpty
	private String firstName;

	public FullName(String lastName, String firstName) {

		this.lastName = lastName;
		this.firstName = firstName;
	}

	// これはFullNameとして返せないのか？
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

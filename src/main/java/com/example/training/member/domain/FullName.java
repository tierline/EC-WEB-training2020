package com.example.training.member.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FullName {
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
		this.fullName = lastName + firstName;
	}

	public FullName() {

	}

}

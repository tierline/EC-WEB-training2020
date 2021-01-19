package com.example.training.member.domain.address;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PostCode {
	@Size(min = 7, max = 8)
	@NotEmpty
	private String postCode;

	public PostCode(String postCode) {
		this.postCode = postCode;
	}
}

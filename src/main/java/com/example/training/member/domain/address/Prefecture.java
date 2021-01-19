package com.example.training.member.domain.address;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Prefecture {
	@Size(min = 2, max = 4)
	@NotEmpty
	private String prefecture;

	public Prefecture(String prefecture) {
		this.prefecture = prefecture;
	}
}

package com.example.training.web.domain.address;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Block {

	@Size(max = 128, message = "入力できる文字数を超過しています。")
	@NotEmpty
	private String value;

	public Block(String value) {
		this.value = value;
	}

	public Block() {

	}
}

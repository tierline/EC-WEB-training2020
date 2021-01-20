package com.example.training.member.domain.address;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;

@Getter
public class Block {

	@Size(max = 128, message = "入力できる文字数を超過しています。")
	@NotEmpty
	private String block;

	public Block(String block) {
		this.block = block;
	}

	public Block() {

	}
}

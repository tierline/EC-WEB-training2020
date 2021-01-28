package com.example.training.common.domain.value.address;

import com.example.training.common.domain.value.Assertion;

import lombok.Getter;

/*
 * 番地
 */
public class Block {

	private final Integer MAX = 130;
	private final Integer MIN = 0;
	@Getter
	private String value;

	/**
	 * 基本コンストラクタ
	 */
	public Block(String value) {
		Assertion.length(value, MIN, MAX);
		this.value = value;
	}

	public Block() {

	}

}

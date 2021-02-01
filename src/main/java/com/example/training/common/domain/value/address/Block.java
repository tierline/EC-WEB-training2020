package com.example.training.common.domain.value.address;

import com.example.training.common.domain.value.Assertion;

import lombok.Getter;

/*
 * 番地
 */
public class Block {

	/**
	 * 番地の値
	 */
	@Getter
	private String value;

	/**
	 * 番地の文字数の最大値
	 */
	private final Integer MAX = 130;
	/**
	 * 番地の文字数の最小値
	 */
	private final Integer MIN = 0;

	/**
	 * 基本コンストラクタ
	 */
	public Block(String value) {
		Assertion.length(value, MIN, MAX);
		this.value = value;
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public Block() {

	}

}

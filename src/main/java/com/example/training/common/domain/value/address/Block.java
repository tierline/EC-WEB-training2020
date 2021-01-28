package com.example.training.common.domain.value.address;

import lombok.Getter;
import lombok.Setter;

/**
 * 番地を表す値オブジェクト
 */
@Getter
@Setter
public class Block {

	/**
	 * 番地の値
	 */
	private String value;

	/**
	 * 基本コンストラクタ
	 *
	 * @param value
	 */
	public Block(String value) {
		this.value = value;
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public Block() {

	}
}

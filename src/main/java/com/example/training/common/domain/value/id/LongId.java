package com.example.training.common.domain.value.id;

import com.example.training.common.domain.value.Assertion;

import lombok.Getter;
import lombok.Setter;

/**
 * IDを表す値オブジェクト
 */
@Getter
@Setter
class LongId {
	/**
	 * IDの値
	 */
	private final Long value;

	private final Long MIN = 0L;
	private final Long MAX = Long.MAX_VALUE;

	/**
	 * 基本コンストラクタ
	 *
	 * @param value
	 */
	public LongId(Long value) {
		Assertion.range(value, MIN, MAX);
		this.value = value;
	}

	/**
	 * 基本コンストラクタ
	 *
	 * @param value
	 */
	public LongId(String value) {
		this.value = Long.parseLong(value);
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public LongId() {
		this.value = 0L;
	}
}

package com.example.training.common.domain.value.id;

import lombok.Getter;

/**
 * 会員IDを表す値オブジェクト
 */
@Getter
class LongId {
	/**
	 * 会員IDの値
	 */
	private final Long value;

	// 要バリデーション追加
	public LongId(Long value) {
		this.value = value;
	}

	// 要バリデーション追加
	public LongId(String value) {
		// TODO try catch
		this.value = Long.parseLong(value);
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public LongId() {
		this.value = 0L;
	}
}

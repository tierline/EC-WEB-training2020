package com.example.training.web.domain.member;

import lombok.Getter;

/**
 * 会員IDを表す値オブジェクト
 */
public class MemberId {
	/**
	 * 会員IDの値
	 */
	@Getter
	private Long value;

	// 要バリデーション追加
	// TODO
	public MemberId(Long value) {
		if (value == null) {
			throw new NullPointerException();
		}
		this.value = value;
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public MemberId() {

	}
}

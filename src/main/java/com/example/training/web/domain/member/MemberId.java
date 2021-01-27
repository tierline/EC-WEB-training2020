package com.example.training.web.domain.member;

import lombok.Getter;
import lombok.Setter;

/**
 * 会員IDを表す値オブジェクト
 */
@Getter
@Setter
public class MemberId {
	/**
	 * 会員IDの値
	 */
	private Long value;

	// 要バリデーション追加
	public MemberId(Long value) {
		this.value = value;
	}

	/**
	 * デフォルトコンストラクタ
	 */
	public MemberId() {

	}
}

package com.example.training.common.domain.value.id;

/**
 * 会員IDを表す値オブジェクト
 */
public class MemberId extends LongId {

	/**
	 * 基本コンストラクタ
	 *
	 * @param id
	 */
	public MemberId(Long id) {
		super(id);
	}

	/**
	 * 基本コンストラクタ
	 *
	 * @param id
	 */
	public MemberId(String id) {
		super(id);
	}
}

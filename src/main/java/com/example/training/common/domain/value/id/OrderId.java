package com.example.training.common.domain.value.id;

import lombok.Getter;

/**
 * 注文IDを表す値オブジェクト
 */
@Getter
public class OrderId extends LongId {

	/**
	 * 基本コンストラクタ
	 *
	 * @param id
	 */
	public OrderId(Long id) {
		super(id);
	}
}

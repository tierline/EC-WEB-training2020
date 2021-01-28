package com.example.training.web.domain.order;

import lombok.Getter;

public class OrderId {

	@Getter
	private Long value;

	/*
	 * 初期化用コンストラクター
	 */
	public OrderId(Long value) {
		if (value == null) {
			throw new NullPointerException();
		}
		this.value = value;
	}
}

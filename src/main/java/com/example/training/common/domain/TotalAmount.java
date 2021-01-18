package com.example.training.common.domain;

import java.util.List;

public class TotalAmount {
	int totalAmount = 0;

	/*
	 * カート内の合計金額の計算
	 */
	public TotalAmount(List<CartItem> items) {
		for (CartItem item : items) {
			this.totalAmount += item.getTotalAmount();
		}
	}

	public int getTotalAmount() {
		return totalAmount;
	}
}

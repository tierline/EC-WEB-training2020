package com.example.training.common.domain;

import lombok.Data;

@Data
public class OrderMonth {
	private int orderId;
	private String orderMonth;
	private String orderDay;

	public OrderMonth(OrderMonth order) {

	}
}

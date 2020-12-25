package com.example.training.common.domain;

import java.util.List;

import lombok.Data;

@Data
public class OrderMonth {
	private int orderId;
	private int orderMonth;
	private List<Order> orderDay;

	public void setOrderMonth(int month) {
		this.orderMonth = month;
	}

	public void add(List<Order> day) {
		this.orderDay = day;
	}

}

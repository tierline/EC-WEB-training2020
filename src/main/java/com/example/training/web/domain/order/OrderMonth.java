package com.example.training.web.domain.order;

import java.time.LocalDateTime;

public class OrderMonth {
	private int orderId;
	private LocalDateTime date;

	public int getOrderId() {
		return this.orderId;
	}

	public LocalDateTime getDate() {
		return this.date;
	}
}

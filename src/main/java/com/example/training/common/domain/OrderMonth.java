package com.example.training.common.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderMonth {
	private int orderId;
	private LocalDateTime date;

	// private DateTimeFormatter formatter =
	// DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分");

	// public void format() {
	// this.orderDateAndTime.format(this.formatter);
	// }
}

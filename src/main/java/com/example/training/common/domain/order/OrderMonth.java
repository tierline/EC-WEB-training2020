package com.example.training.common.domain.order;

import java.time.LocalDate;

import lombok.Data;

@Data
public class OrderMonth {
	private int orderId;
	private LocalDate date;
}

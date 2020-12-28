package com.example.training.common.domain;

import java.time.LocalDate;

import lombok.Data;

@Data
public class OrderMonth {
	private int orderId;
	private int orderMonth;
	private LocalDate date;
}

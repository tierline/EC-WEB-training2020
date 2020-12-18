package com.example.training.common.domain;

import lombok.Data;

@Data
public class OrderHistory {
	private String memberId;
	private String orderId;
	private String name;
	private int unitPrice;
	private int quantity;
	private String imagePath;
	private String date;
}

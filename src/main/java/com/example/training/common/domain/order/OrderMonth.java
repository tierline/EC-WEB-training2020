package com.example.training.common.domain.order;

import java.time.LocalDate;

import com.example.training.member.domain.MemberId;

public class OrderMonth {
	private MemberId memberId;
	private LocalDate date;

	public LocalDate getDate() {
		return this.date;
	}
}

package com.example.training.domain.order;

import java.time.LocalDateTime;

import com.example.training.domain.member.MemberId;

public class OrderMonth {
	private MemberId memberId;
	private LocalDateTime date;

	public LocalDateTime getDate() {
		return this.date;
	}
}

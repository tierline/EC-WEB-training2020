package com.example.training.common.domain.order;

import java.time.LocalDateTime;

import com.example.training.member.domain.MemberId;

public class OrderMonth {
	private MemberId memberId;
	private LocalDateTime date;

	public LocalDateTime getDate() {
		return this.date;
	}
}

package com.example.training.web.domain.order;

import java.time.LocalDateTime;

import com.example.training.web.domain.member.MemberId;

public class OrderMonth {
	private MemberId memberId;
	private LocalDateTime date;

	public LocalDateTime getDate() {
		return this.date;
	}
}

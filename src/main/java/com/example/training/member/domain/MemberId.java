package com.example.training.member.domain;

import lombok.Getter;

@Getter
public class MemberId {
	private Long memberId;

	// 要バリデーション追加
	public MemberId(Long memberId) {
		this.memberId = memberId;
	}

	public MemberId() {

	}
}

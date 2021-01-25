package com.example.training.member.domain;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberId {
	@NotNull
	private Long value;

	// 要バリデーション追加
	public MemberId(Long memberId) {
		this.value = memberId;
	}

	// 要バリデーション追加
	public MemberId(String memberId) {
		this.value = Long.parseLong(memberId);
	}

	public MemberId() {

	}
}

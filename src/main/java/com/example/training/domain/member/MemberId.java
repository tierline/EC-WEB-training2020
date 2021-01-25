package com.example.training.domain.member;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberId {
	@NotNull
	private Long value;

	// 要バリデーション追加
	public MemberId(Long value) {
		this.value = value;
	}

	public MemberId() {

	}
}

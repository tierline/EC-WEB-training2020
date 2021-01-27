package com.example.training.web.domain.member;

import lombok.Data;

@Data
public class MemberSession {

	private Long memberId;

	private String email;

	private String password;

	private String memberStatus;

//	public MemberSession(MemberEntity entity) {
//		this.memberId = new MemberId(entity.getMemberId());
//		this.email = new Email(entity.getEmail());
//		this.memberStatus = MemberStatus.getStatus(entity.getStatus());
//	}
}

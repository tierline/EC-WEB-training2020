package com.example.training.domain.member;

public enum MemberStatus {
	APPROVAL, UNAPPROVED;

	private MemberStatus value;

	/*
	 * memberの認証状態を返す
	 */
	public static MemberStatus getStatus(String memberStatus) {
		MemberStatus value = MemberStatus.valueOf(memberStatus);
		return value;
//		for (MemberStatus status : MemberStatus.values()) {
//			if(status == memberStatus) {
//				return status.();
//			}
//		}
	}
};

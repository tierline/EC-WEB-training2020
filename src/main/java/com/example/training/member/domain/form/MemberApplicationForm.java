package com.example.training.member.domain.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.example.training.member.domain.Email;
import com.example.training.member.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class MemberApplicationForm {

	private Email email;

	@NotEmpty
	@Size(max = 16, message = "パスワードは16文字以内で入力してください")
	private String password;

	public Member createMember(String passwordDigest) {
		return new Member(this, passwordDigest);
	}

}

package com.example.training.web.domain.member;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class MemberLoginForm {

	@NotEmpty
	@Email
	private String email;

	@NotEmpty
	private String password;

}

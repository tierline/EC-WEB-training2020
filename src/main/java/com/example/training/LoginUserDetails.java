package com.example.training;

import com.example.training.domain.Employee;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LoginUserDetails extends User {
	private final Employee employee;

	public LoginUserDetails(Employee employee, String role) {
		super(employee.getEmail(), employee.getPassword(), AuthorityUtils.createAuthorityList(role));
		this.employee = employee;
	}
}

package com.example.training;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.training.domain.Employee;
import com.example.training.repository.UserRepository;

@Service
public class LoginUserDetailsService implements UserDetailsService {
//	@Autowired
//	EmployeeExample employeeExample;

	@Autowired
	UserRepository userRepository;

	/**
	 * 登録情報の取得
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Employee> employeeOpt = userRepository.findByEmail(email);

		if (employeeOpt.isEmpty()) {
			throw new UsernameNotFoundException("email or password");
		}
		String role = "ROLE_ADMIN";

		return new LoginUserDetails(employeeOpt.get(), role);
	}
}

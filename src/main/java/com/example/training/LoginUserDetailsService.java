package com.example.training;

import java.util.Optional;

import com.example.training.domain.Member;
import com.example.training.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginUserDetailsService implements UserDetailsService {
	// @Autowired
	// EmployeeExample employeeExample;

	@Autowired
	MemberRepository memberRepository;

	/**
	 * 登録情報の取得
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Member> memberOpt = memberRepository.findByEmail(email);

		if (memberOpt.isEmpty()) {
			throw new UsernameNotFoundException("email or password");
		}
		String role = "ROLE_ADMIN";

		return new LoginUserDetails(memberOpt.get(), role);
	}
}

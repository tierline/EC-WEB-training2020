package com.example.training.restApi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.training.common.domain.Product;
import com.example.training.common.repository.ProductRepository;
import com.example.training.member.Service.MemberService;
import com.example.training.member.domain.Member;
import com.example.training.member.repository.MemberRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RestApiController {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private MemberService memberService;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("/common/products")
	public List<Product> product() {
		List<Product> items = productRepository.findAll();
		return items;
	}

	@PostMapping("/members/auth/applicate")
	@ResponseBody
	public Member create(@RequestBody Member member) {
		memberService.create(member);
		return member;
	}

	@PostMapping("/members/auth/login")
	@ResponseBody
	public Boolean login(@RequestBody Member member) {
		String password = member.getPassword();
		Optional<Member> memberDetail = memberRepository.findByEmail(member.getEmail());
		if (memberDetail.isPresent()) {
			var result = bCryptPasswordEncoder.matches(password, memberDetail.get().getPassword());
			if (result) {
				return true;
			}
		}
		return false;
	}
}

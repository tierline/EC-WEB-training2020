package com.example.training.restApi.member.order;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.training.common.domain.OrderService;
import com.example.training.common.repository.OrderRepository;
import com.example.training.member.domain.Member;
import com.example.training.member.repository.MemberRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/member/order")
public class ApiOrderController {

	@Autowired
	private HttpSession session;

	@Autowired
	private OrderService orderService;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private OrderRepository orderRepository;

	/**
	 * 注文処理を行う
	 */
	@PostMapping("/save")
	public String save() {
		return "注文処理を行いました 住所は...";
	}

	@PostMapping("/history")
	@ResponseBody
	public int fetch(@RequestBody Member member) {
		Optional<Member> memberId = memberRepository.findByEmail(member.getEmail());
		if (memberId.isPresent()) {
			int id = memberId.get().getId();
			return id;
		}
		return 0;
	}

	// /**
	// * 注文処理を行う
	// */
	// @PostMapping("/save")
	// public String save(@ModelAttribute("orderForm") @Valid OrderForm orderForm,
	// BindingResult result, Model model) {
	// if (result.hasErrors()) {
	// return form(orderForm, model);
	// } else {
	// Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
	// int orderId = orderService.order(orderForm, cart);
	// session.setAttribute(Cart.SESSION_NAME, new Cart());
	// return "redirect:/member/order/complete/" + orderId;
	// }
	// }

}

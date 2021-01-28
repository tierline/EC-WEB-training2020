package com.example.training.mobile.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.training.common.repository.MemberRepository;
import com.example.training.common.repository.OrderRepository;
import com.example.training.web.domain.cart.Cart;
import com.example.training.web.domain.member.Member;
import com.example.training.web.domain.member.MemberId;
import com.example.training.web.domain.order.Order;
import com.example.training.web.domain.order.OrderForm;
import com.example.training.web.domain.order.OrderFormEntity;
import com.example.training.web.domain.order.OrderHistoryAssembler;
import com.example.training.web.domain.order.OrderHistoryByMonth;
import com.example.training.web.domain.order.OrderItem;
import com.example.training.web.domain.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/member/order")
public class ApiOrderController {

	@Autowired
	private HttpSession session;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderService orderService;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private OrderHistoryAssembler orderHistoryAssembler;

	/**
	 * 注文処理を行う
	 */
	@PostMapping("/save")
	public Integer save(@RequestBody OrderFormEntity order) {
		Member member = (Member) session.getAttribute(Member.SESSION_NAME);
		MemberId memberId = member.getMemberId();
		OrderForm orderForm = new OrderForm(order, memberId);
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		// int orderId = orderService.order(orderForm, cart);
		// memberRepository.updateAtOrder(orderForm);
		session.setAttribute(Cart.SESSION_NAME, new Cart());

		// TODO : orderを返すように。
		// return orderId;
		return 0;
	}

	/**
	 * 注文番号から注文明細を返す
	 */
	@GetMapping("/orderDetails/{id}")
	public Order orderDetails(@PathVariable Integer id) {
		Order order = orderRepository.findById(id);

		return order;
	}

	// fix 下と同じでは？
	/**
	 * 注文番号から注文商品を返す
	 */
	@GetMapping("/orderedItemList/{id}")
	public List<OrderItem> orderedItemList(@PathVariable int id) {
		List<OrderItem> items = orderRepository.findOrderItemsById(id);

		return items;
	}

	@GetMapping("/history/item/{id}")
	public List<OrderItem> orderItemList(@PathVariable int id) {
		List<OrderItem> list = orderRepository.findOrderItemsById(id);
		return list;
	}

	/*
	 * 購入履歴の取得
	 */
	// TOREVIEW
	// sessionからの取得に変更
	@GetMapping("/history")
	public Map<Integer, List<OrderHistoryByMonth>> history() {
		Member member = (Member) session.getAttribute(Member.SESSION_NAME);
		Map<Integer, List<OrderHistoryByMonth>> result = orderHistoryAssembler.create(member);
		return result;
	}

}

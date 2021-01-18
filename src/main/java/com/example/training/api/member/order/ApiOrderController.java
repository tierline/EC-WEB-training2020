package com.example.training.api.member.order;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.training.common.domain.cart.Cart;
import com.example.training.common.domain.order.Order;
import com.example.training.common.domain.order.OrderForm;
import com.example.training.common.domain.order.OrderHistoryAssembler;
import com.example.training.common.domain.order.OrderItem;
import com.example.training.common.domain.order.OrderMonth;
import com.example.training.common.repository.OrderRepository;
import com.example.training.common.service.OrderService;
import com.example.training.member.domain.Member;
import com.example.training.member.repository.MemberRepository;

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
	public Integer save(@RequestBody OrderForm order) {
		Member member = (Member) session.getAttribute(Member.SESSION_NAME);
		int memberId = member.getId();
		OrderForm orderForm = new OrderForm(order, memberId);
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		int orderId = orderService.order(orderForm, cart);
		memberRepository.updateAtOrder(orderForm);
		session.setAttribute(Cart.SESSION_NAME, new Cart());

		return orderId;
	}

	/**
	 * 注文番号から注文明細を返す
	 */
	@GetMapping("/orderDetails/{id}")
	public Order orderDetails(@PathVariable Integer id) {
		Order order = orderRepository.findById(id);

		return order;
	}

	/**
	 * 注文番号から注文明細を返す
	 */
	@GetMapping("/orderedItemList/{id}")
	public List<OrderItem> orderedItemList(@PathVariable Integer id) {
		Order order = orderRepository.findById(id);
		List<OrderItem> items = orderRepository.findItemsByOrder(order);
		return items;

	}

	/*
	 * 購入履歴の取得
	 */
	// TOREVIEW
	// sessionからの取得に変更
	@GetMapping("/history")
	public Map<Integer, List<OrderMonth>> history() {
		Member member = (Member) session.getAttribute(Member.SESSION_NAME);
		Map<Integer, List<OrderMonth>> result = orderHistoryAssembler.create(member);
		return result;
	}

	@GetMapping("/history/item/{id}")
	public List<OrderItem> orderItemList(@PathVariable int id) {
		List<OrderItem> list = orderRepository.findByOrderItem(id);
		return list;
	}
}

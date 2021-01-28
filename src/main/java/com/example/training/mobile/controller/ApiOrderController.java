package com.example.training.mobile.controller;

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

import com.example.training.common.domain.Cart;
import com.example.training.common.domain.Member;
import com.example.training.common.domain.Order;
import com.example.training.common.domain.OrderItem;
import com.example.training.common.domain.value.id.MemberId;
import com.example.training.common.domain.value.id.OrderId;
import com.example.training.common.repository.MemberRepository;
import com.example.training.common.repository.OrderRepository;
import com.example.training.common.service.OrderService;
import com.example.training.web.controller.order.OrderForm;
import com.example.training.web.controller.order.OrderHistoryAssembler;
import com.example.training.web.controller.order.OrderHistoryByMonth;

/**
 * 注文のコントローラ(Mobile)
 */
@CrossOrigin
@RestController
@RequestMapping("/api/member/order")
// TODO API
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
	// TODO
	@PostMapping("/save")
	public Integer save(@RequestBody OrderSaveCommand order) {
		Member member = (Member) session.getAttribute(Member.SESSION_NAME);
		MemberId memberId = member.getMemberId();
		OrderForm orderForm = new OrderForm(order, memberId);
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		Order order = orderService.order(orderForm, cart);
//		memberRepository.updateAtOrder(orderForm);
		// session.setAttribute(Cart.SESSION_NAME, new Cart());

		// return order;
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
	public Order orderDetails(@PathVariable Long id) {
		OrderId orderId = new OrderId(id);
		Order order = orderRepository.findById(orderId);

		return order;
	}

	// fix 下と同じでは？
	// TODO どちらか削除
	/**
	 * 注文番号から注文商品を返す
	 */
	@GetMapping("/orderedItemList/{id}")
	public List<OrderItem> orderedItemList(@PathVariable Long id) {
		OrderId orderId = new OrderId(id);
		List<OrderItem> items = orderRepository.findOrderItemsById(orderId);

		return items;
	}

	@GetMapping("/history/item/{id}")
	public List<OrderItem> orderItemList(@PathVariable Long id) {
		OrderId orderId = new OrderId(id);
		List<OrderItem> list = orderRepository.findOrderItemsById(orderId);
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

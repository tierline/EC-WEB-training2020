package com.example.training.common.service;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.example.training.common.domain.Cart;
import com.example.training.common.domain.Order;
import com.example.training.common.domain.OrderForm;
import com.example.training.common.domain.OrderItem;
import com.example.training.common.repository.OrderRepository;
import com.example.training.member.domain.Member;
import com.example.training.member.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	public static final String SESSION_NAME = "ORDER_PERSON";

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private HttpSession session;

	public int order(@Valid OrderForm orderForm, Cart cart) {
		Order order = orderForm.createOrder(cart);
		this.saveByOrder(order, cart);
		memberRepository.updateAtOrder(orderForm); // SQLをあまり増やさない
		session.setAttribute(Member.SESSION_NAME, memberRepository.findById(orderForm.getMemberId()));
		return order.getId();
	}

	// トランザクションで区切る必要
	private void saveByOrder(Order order, Cart cart) {
		orderRepository.save(order);
		List<OrderItem> items = order.createItems(cart);
		for (OrderItem item : items) {
			orderRepository.saveItem(item, order.getId());
		}
	}
}

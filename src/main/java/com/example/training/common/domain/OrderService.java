package com.example.training.common.domain;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.training.common.repository.OrderRepository;
import com.example.training.member.domain.Member;
import com.example.training.member.repository.MemberRepository;

@Service
public class OrderService {
	public static final String SESSION_NAME = "ORDER_PERSON";

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private HttpSession session;
// 色々しすぎてる
	public int order(@Valid OrderForm orderForm, Cart cart) {
		Order order = orderForm.createOrder();
		int memberId = orderForm.getMemberId();
		order.setMemberId(memberId);
		order.setPrice(cart);
		orderRepository.save(order);
		memberRepository.updateAtOrder(orderForm);
		session.setAttribute(Member.SESSION_NAME, memberRepository.findById(memberId));
		List<OrderItem> items = order.createItems(cart);
		this.saveItems(order, items);
		return order.getId();
	}

	public void saveItems(Order order, List<OrderItem> items) {
		for (OrderItem item : items) {
			orderRepository.saveItem(item, order.getId());
		}
	}
}

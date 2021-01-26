package com.example.training.web.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.training.common.repository.MemberRepository;
import com.example.training.common.repository.OrderRepository;
import com.example.training.web.domain.cart.Cart;
import com.example.training.web.domain.member.Member;
import com.example.training.web.domain.member.MemberId;
import com.example.training.web.domain.order.Order;
import com.example.training.web.domain.order.OrderForm;
import com.example.training.web.domain.order.OrderItem;

@Service
public class OrderService {
	public static final String SESSION_NAME = "ORDER_PERSON";

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private MemberRepository memberRepository;

	/*
	 * 注文者情報の保存
	 */
	public Order order(OrderForm orderForm, Cart cart) {
		Order order = orderForm.createOrder(cart);
		this.saveByOrder(order, cart);
		Member member = new Member(memberRepository.findById(new MemberId(orderForm.getMemberId())));
		// 引数はmemberにすべき
//		orderForm.updateMember(member);
		// 後で修正
		memberRepository.updateAtOrder(member);
		// 注文の操作と関係ないcontrollerへ
		return order;
	}

	/**
	 *
	 * 注文と注文された商品を保存する
	 *
	 * @param order
	 * @param cart
	 */
	private void saveByOrder(Order order, Cart cart) {
		orderRepository.save(order);
		List<OrderItem> items = order.createItems(cart);
		for (OrderItem item : items) {
			orderRepository.saveItem(item, order.getOrderId());
		}
	}
}

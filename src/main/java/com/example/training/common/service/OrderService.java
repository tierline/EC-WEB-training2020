package com.example.training.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.training.common.domain.cart.Cart;
import com.example.training.common.domain.order.Order;
import com.example.training.common.domain.order.OrderForm;
import com.example.training.common.domain.order.OrderItem;
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

//コメントを書く
	// serviceクラスにsessionを使わない
	public Order order(OrderForm orderForm, Cart cart) {
		Order order = orderForm.createOrder(cart);
		this.saveByOrder(order, cart);
		Member member = new Member(memberRepository.findById(orderForm.getMemberId()));
		// 引数はmemberにすべき
		orderForm.upDateMember(member);
		// 後で修正

		// 注文の操作と関係ないcontrollerへ
		return order;
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

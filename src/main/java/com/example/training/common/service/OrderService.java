package com.example.training.common.service;

import java.util.List;

import javax.validation.Valid;

import com.example.training.common.domain.cart.Cart;
import com.example.training.common.domain.order.Order;
import com.example.training.common.domain.order.OrderForm;
import com.example.training.common.domain.order.OrderItem;
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

	/**
	 *
	 * 注文処理をする
	 *
	 * @param orderForm
	 * @param cart
	 * @return 注文番号
	 */
	public int order(@Valid OrderForm orderForm, Cart cart) {
		Order order = orderForm.createOrder(cart);
		this.saveByOrder(order, cart);
		memberRepository.updateAtOrder(orderForm); // formは渡さないmemberとして！
		Member member = new Member(memberRepository.findById(orderForm.getMemberId()));
		// session.setAttribute(Member.SESSION_NAME, member); 不要
		return order.getId(); // fix orderそのものを返す
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
			orderRepository.saveItem(item, order.getId());
		}
	}
}

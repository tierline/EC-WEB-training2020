package com.example.training.web.domain.service;

import java.util.List;

import javax.validation.Valid;

import com.example.training.common.repository.MemberRepository;
import com.example.training.common.repository.OrderRepository;
import com.example.training.web.domain.cart.Cart;
import com.example.training.web.domain.order.Order;
import com.example.training.web.domain.order.OrderForm;
import com.example.training.web.domain.order.OrderItem;

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
		// fix メンバーの取得?
		memberRepository.updateAtOrder(orderForm); // formは渡さないmemberとして！
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
		orderRepository.create(order);
		List<OrderItem> items = order.createOrderItemsFromCart(cart);
		for (OrderItem item : items) {
			orderRepository.createItem(item, order.getId());
		}
	}
}

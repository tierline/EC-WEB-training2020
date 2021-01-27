package com.example.training.web.domain.service;

import java.util.List;

import com.example.training.common.repository.MemberRepository;
import com.example.training.common.repository.OrderRepository;
import com.example.training.web.domain.cart.Cart;
import com.example.training.web.domain.order.Order;
import com.example.training.web.domain.order.OrderItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 注文（ドメイン）のサービスクラス
 */
@Service
public class OrderService {
	public static final String SESSION_NAME = "ORDER_PERSON";

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private MemberRepository memberRepository;

	/**
	 * 注文処理をする。
	 *
	 * @param orderForm 注文フォーム
	 * @param cart      カート
	 * @return 注文番号
	 */
	public Order order(Order order, Cart cart) {
		this.saveByOrder(order, cart);
		// memberRepository.updateAtOrder(orderForm); // formは渡さないmemberとして！ fix :
		// update(member)に変更する。
		return order;
	}

	/**
	 * 注文内容と注文商品を保存する
	 *
	 * @param order 注文内容
	 * @param cart  カート
	 */
	private void saveByOrder(Order order, Cart cart) {
		orderRepository.create(order);
		List<OrderItem> items = order.createOrderItems(cart, order);
		for (OrderItem item : items) {
			orderRepository.createItem(item);
		}
	}
}

package com.example.training.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.training.common.domain.Cart;
import com.example.training.common.domain.Member;
import com.example.training.common.domain.Order;
import com.example.training.common.domain.OrderItem;
import com.example.training.common.repository.MemberRepository;
import com.example.training.common.repository.OrderRepository;

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
		// if()チェックボックス設置更新するかしないか
		this.updateMemberByOrder(order);
		return order;
	}

	/**
	 * 注文内容と注文商品を保存する
	 *
	 * @param order 注文内容
	 * @param cart  カート
	 * 
	 */
	private void saveByOrder(Order order, Cart cart) {
		orderRepository.create(order);
		List<OrderItem> items = order.createOrderItems(cart, order);
		for (OrderItem item : items) {
			orderRepository.createItem(item);
		}
	}

	/**
	 * 注文内容で会員情報を更新する
	 *
	 * @param order 注文内容
	 */
	private void updateMemberByOrder(Order order) {
		Member member = new Member(order);
		memberRepository.updateAtOrder(member);
	}

}

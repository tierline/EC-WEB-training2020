package com.example.training.common.repository;

import java.util.List;

import com.example.training.web.domain.member.MemberId;
import com.example.training.web.domain.order.Order;
import com.example.training.web.domain.order.OrderHistoryByMonth;
import com.example.training.web.domain.order.OrderItem;

import org.apache.ibatis.annotations.Mapper;

/**
 * 注文リポジトリ
 */
@Mapper
public interface OrderRepository {

	/**
	 * 注文IDで注文内容を取得する。
	 *
	 * @param id
	 * @return 注文内容
	 */
	public Order findByOrderId(int id);

	/**
	 * 注文IDで注文商品を取得する。
	 *
	 * @param order
	 * @return 注文商品リスト
	 */
	public List<OrderItem> findOrderItemsByOrderId(int id);

	/**
	 * 会員IDで月毎の注文内容を取得する。
	 *
	 * @param memberId
	 * @return 月毎の注文履歴
	 */
	public List<OrderHistoryByMonth> findOrderHistoryByMonthByMemberId(MemberId memberId);

	/**
	 * 注文内容を保存する。
	 *
	 * @param order 注文内容
	 */
	public int create(Order order);

	/**
	 * 注文商品を保存する。
	 *
	 * @param item 注文商品
	 */
	public void createItem(OrderItem item);

}

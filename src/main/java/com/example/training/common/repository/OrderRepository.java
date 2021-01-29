package com.example.training.common.repository;

import java.util.List;

import com.example.training.common.domain.Order;
import com.example.training.common.domain.OrderItem;
import com.example.training.common.domain.value.id.MemberId;
import com.example.training.web.controller.order.OrderHistoryByMonth;

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
	public Order findById(int id);

	/**
	 * 注文IDで注文商品を取得する。
	 *
	 * @param order
	 * @return 注文商品リスト
	 */
	public List<OrderItem> findOrderItemsById(int id);

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
	public int save(Order order);

	/**
	 * 注文商品を保存する。
	 *
	 * @param item 注文商品
	 */
	public void saveItem(OrderItem item);

}

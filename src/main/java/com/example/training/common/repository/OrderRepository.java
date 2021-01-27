package com.example.training.common.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.training.web.domain.member.MemberId;
import com.example.training.web.domain.order.Order;
import com.example.training.web.domain.order.OrderHistoryByMonth;
import com.example.training.web.domain.order.OrderItem;

<<<<<<< HEAD
=======
import org.apache.ibatis.annotations.Mapper;

/**
 * 注文リポジトリ
 */
>>>>>>> origin/kato
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

<<<<<<< HEAD
//TODO
	public void saveItem(@Param("item") OrderItem item, @Param("id") Long id);

	public void createItem(@Param("item") OrderItem item, @Param("id") int id);

	public List<OrderItem> findItemsByOrder(Order order);

	public Order findById(int id);

	public List<OrderMonth> findByOrderMonthByMemberId(MemberId memberId);

	public List<OrderItem> findByOrderItem(int id);
=======
	/**
	 * 注文商品を保存する。
	 *
	 * @param item 注文商品
	 */
	public void createItem(OrderItem item);
>>>>>>> origin/kato

}

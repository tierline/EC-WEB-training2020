package com.example.training.common.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.training.common.domain.order.Order;
import com.example.training.common.domain.order.OrderItem;
import com.example.training.common.domain.order.OrderMonth;
import com.example.training.member.domain.MemberId;

@Mapper
public interface OrderRepository {

	public int save(Order order);

	public void saveItem(@Param("item") OrderItem item, @Param("id") int id);

	public List<OrderItem> findItemsByOrder(Order order);

	public Order findById(int id);

	public List<OrderMonth> findByOrderMonthByMemberId(MemberId id);

	public List<OrderItem> findByOrderItem(int id);

	public void saveByOrder(Order order);

}

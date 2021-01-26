package com.example.training.common.repository;

import java.util.List;

import com.example.training.web.domain.member.MemberId;
import com.example.training.web.domain.order.Order;
import com.example.training.web.domain.order.OrderItem;
import com.example.training.web.domain.order.OrderMonth;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderRepository {

	public int create(Order order);

	public void createItem(@Param("item") OrderItem item, @Param("id") int id);

	public List<OrderItem> findItemsByOrder(Order order);

	public Order findById(int id);

	public List<OrderMonth> findByOrderMonthByMemberId(MemberId memberId);

	public List<OrderItem> findByOrderItem(int id);

}

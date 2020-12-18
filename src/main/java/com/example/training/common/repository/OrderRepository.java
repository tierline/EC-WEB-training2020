package com.example.training.common.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.training.common.domain.Order;
import com.example.training.common.domain.OrderHistory;
import com.example.training.common.domain.OrderItem;

@Mapper
public interface OrderRepository {

	public int save(Order order);

	public void saveItem(@Param("item") OrderItem item, @Param("id") int id);

	public List<OrderItem> findItemsByOrder(Order order);

	public Order findById(int id);

	public List<OrderHistory> findItemByOrderHistory(int memberId);

}

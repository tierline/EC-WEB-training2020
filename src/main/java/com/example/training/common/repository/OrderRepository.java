package com.example.training.common.repository;

import java.util.List;

import com.example.training.common.domain.Order;
import com.example.training.common.domain.OrderItem;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderRepository {

	public int save(Order order);

	public void saveItem(@Param("item") OrderItem item, @Param("id") int id);

	public List<OrderItem> findItemsByOrder(Order order);

	public Order findById(int id);

}

package com.example.training.member.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.training.member.domain.Order;
import com.example.training.member.domain.OrderItem;

@Mapper
public interface OrderRepository {

	public int save(Order order);

	public void saveItem(@Param("item") OrderItem item, int id);

	public List<OrderItem> findItemsByOrder(Order order);

	public Order findById(int id);

}

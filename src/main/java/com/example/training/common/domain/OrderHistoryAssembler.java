package com.example.training.common.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.example.training.common.repository.OrderRepository;
import com.example.training.member.domain.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderHistoryAssembler {

	@Autowired
	private OrderRepository orderRepository;

	public Map<Integer, List<OrderMonth>> create(Member member) {
		int id = member.getId();
		List<OrderMonth> orders = orderRepository.findByOrderMonthByMemberId(id);
		Map<Integer, List<OrderMonth>> map = new TreeMap<>();
		for (OrderMonth order : orders) {
			int month = order.getDate().getMonthValue();
			if (map.containsKey(month)) {
				map.get(month).add(order);
			} else {
				map.put(month, new ArrayList<OrderMonth>());
				map.get(month).add(order);
			}
		}
		return map;
	}
}

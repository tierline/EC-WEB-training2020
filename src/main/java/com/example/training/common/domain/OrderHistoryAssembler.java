package com.example.training.common.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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

// TOREVIEW
	public Map<Integer, List<OrderMonth>> create(Member member) {
		int id = member.getId();
		List<OrderMonth> orderMonthList = orderRepository.findByOrderMonthByMemberId(id);
		Map<Integer, List<OrderMonth>> map = new TreeMap<>();
		for (OrderMonth order : orderMonthList) {
			LocalDate date = order.getDate();
			int month = date.getMonthValue();
			if (map.containsKey(month)) {
				map.get(month).add(order);
			} else {
				map.put(month, new ArrayList<OrderMonth>(Arrays.asList(order)));
			}
		}
		return map;
	}
}

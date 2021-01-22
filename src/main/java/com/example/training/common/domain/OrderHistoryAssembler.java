package com.example.training.common.domain;

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
		for (OrderMonth orderMonth : orderMonthList) {
			int month = orderMonth.getDate().getMonthValue();
			if (map.containsKey(month)) {
				map.get(month).add(orderMonth);
			} else {
				map.put(month, new ArrayList<OrderMonth>(Arrays.asList(orderMonth)));
			}
		}
		return map;
	}
}

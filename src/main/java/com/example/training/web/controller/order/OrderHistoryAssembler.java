package com.example.training.web.controller.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.example.training.common.domain.value.id.MemberId;
import com.example.training.common.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 注文履歴データを組み立てるクラス
 */
@Service
public class OrderHistoryAssembler {

	@Autowired
	private OrderRepository orderRepository;

	/**
	 * 会員の月別の注文履歴リストを返す
	 *
	 * @param member 会員
	 * @return 月別注文履歴リスト
	 */
	public Map<Integer, List<OrderHistoryByMonth>> create(MemberId memberId) {
		List<OrderHistoryByMonth> orderHistoryByMonthList = orderRepository.findOrderHistoryByMonthByMemberId(memberId);
		Map<Integer, List<OrderHistoryByMonth>> map = new TreeMap<>();
		for (OrderHistoryByMonth orderHistoryByMonth : orderHistoryByMonthList) {
			int month = orderHistoryByMonth.getDate().getMonthValue();
			if (map.containsKey(month)) {
				map.get(month).add(orderHistoryByMonth);
			} else {
				map.put(month, new ArrayList<OrderHistoryByMonth>(Arrays.asList(orderHistoryByMonth)));
			}
		}
		return map;
	}
}
package com.example.training.web.domain.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.training.common.repository.OrderRepository;
import com.example.training.web.domain.member.Member;
import com.example.training.web.domain.member.MemberId;

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
    public Map<Integer, List<OrderHistoryByMonth>> create(Member member) {
        MemberId memberId = member.getId();
        List<OrderHistoryByMonth> orderHistoryByMonthList = orderRepository.findOrderHistoryByMonthByMemberId(memberId);
        Map<Integer, List<OrderHistoryByMonth>> map = new TreeMap<>();
        for (OrderHistoryByMonth orderHistoryByMonth : orderHistoryByMonthList) {
            LocalDateTime date = orderHistoryByMonth.getDate();
            int month = date.getMonthValue();
            if (map.containsKey(month)) {
                map.get(month).add(orderHistoryByMonth);
            } else {
                map.put(month, new ArrayList<OrderHistoryByMonth>(Arrays.asList(orderHistoryByMonth)));
            }
        }
        return map;
    }
}

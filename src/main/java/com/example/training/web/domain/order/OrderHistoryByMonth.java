package com.example.training.web.domain.order;

import java.time.LocalDateTime;

import lombok.Getter;

/**
 * 月毎の注文履歴クラス
 */
@Getter
public class OrderHistoryByMonth {

    /**
     * 注文ID
     */
    private int orderId;

    /**
     * 注文日時
     */
    private LocalDateTime date;
}

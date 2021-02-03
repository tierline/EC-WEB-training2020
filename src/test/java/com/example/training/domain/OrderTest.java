package com.example.training.domain;

import com.example.training.common.domain.Cart;
import com.example.training.common.domain.Product;
import com.example.training.common.domain.value.Price;
import com.example.training.common.domain.value.ProductName;
import com.example.training.common.domain.value.id.ProductId;

import org.junit.jupiter.api.Test;

/**
 * 注文のテスト
 */
public class OrderTest {

  /**
   *　
   */
  @Test
  void orderSave() {
    Product product = new Product(new ProductId(1L), new ProductName("ガム"), new Price(20));
    Cart cart = new Cart();
    cart.add(product);
  }

  // /**
  // * 月毎の注文履歴リストが作成できる。
  // */
  // @Test
  // void canCreateOrderByMonthList() {
  // OrderHistoryAssembler history = new OrderHistoryAssembler();
  // List<Order> orders = new ArrayList<Order>();
  // Order order1 = new Order(new OrderId(1L), new MemberId(1L),
  // LocalDateTime.of(2021, 1, 1, 12, 00, 00));
  // Order order2 = new Order(new OrderId(2L), new MemberId(1L),
  // LocalDateTime.of(2021, 1, 2, 12, 10, 10));
  // Order order3 = new Order(new OrderId(3L), new MemberId(1L),
  // LocalDateTime.of(2021, 1, 3, 12, 20, 20));
  // Order order4 = new Order(new OrderId(1L), new MemberId(1L),
  // LocalDateTime.of(2021, 2, 4, 12, 30, 30));
  // Order order5 = new Order(new OrderId(2L), new MemberId(1L),
  // LocalDateTime.of(2021, 3, 5, 12, 40, 40));
  // Order order6 = new Order(new OrderId(3L), new MemberId(1L),
  // LocalDateTime.of(2021, 4, 6, 12, 50, 50));
  // orders.add(order1);
  // orders.add(order2);
  // orders.add(order3);
  // orders.add(order4);
  // orders.add(order5);
  // orders.add(order6);
  // history.create(new MemberId(1L));
  // }
}

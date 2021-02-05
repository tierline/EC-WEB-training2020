package com.example.training.service;

import java.time.LocalDateTime;

import com.example.training.common.controller.MemberDTO;
import com.example.training.common.controller.OrderSaveCommand;
import com.example.training.common.domain.Cart;
import com.example.training.common.domain.Order;
import com.example.training.common.domain.Product;
import com.example.training.common.domain.value.Email;
import com.example.training.common.domain.value.Price;
import com.example.training.common.domain.value.ProductName;
import com.example.training.common.domain.value.Quantity;
import com.example.training.common.domain.value.id.MemberId;
import com.example.training.common.domain.value.id.OrderId;
import com.example.training.common.domain.value.id.ProductId;
import com.example.training.common.entity.MemberEntity;
import com.example.training.common.repository.MemberRepository;
import com.example.training.common.repository.OrderRepository;
import com.example.training.common.service.OrderService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderServiceTest {

  @Autowired
  private MemberRepository memberRepository;

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private OrderService orderService;

  /**
   * 会員インスタンスが生成できる。
   */
  @Test
  void testCreate() {
    MemberEntity memberEntity = memberRepository.findByEmail(new Email("test@example.com")).orElseThrow();
    OrderSaveCommand command = new OrderSaveCommand();
    MemberDTO memberDTO = new MemberDTO(memberEntity);
    command.setMemberInfo(memberDTO);

    Cart cart = new Cart();
    Product p1 = new Product(new ProductId(1L), new ProductName("ガム"), new Price(100));
    Product p2 = new Product(new ProductId(2L), new ProductName("チョコ"), new Price(200));

    Order order = new Order(command, cart);

    Assertions.assertNotNull(order);
  }

  /**
   * 注文処理ができる。
   */
  @Test
  void testOrder() {
    OrderId orderId = new OrderId(1L);
    MemberId memberId = new MemberId(1L);
    Order order = new Order(orderId, memberId, LocalDateTime.now());
    Cart cart = new Cart();
    Product p1 = new Product(new ProductId(1L), new ProductName("ガム"), new Price(100));
    Product p2 = new Product(new ProductId(2L), new ProductName("チョコ"), new Price(200));

    cart.add(p1, new Quantity(1));
    cart.add(p2, new Quantity(2));

    orderService.order(order, cart);
    Order ordered = orderRepository.findById(orderId);

    Assertions.assertNotNull(ordered);
    Assertions.assertEquals(1L, ordered.getId());
    Assertions.assertEquals(500, ordered.getTotalPrice().getValue());

  }
}

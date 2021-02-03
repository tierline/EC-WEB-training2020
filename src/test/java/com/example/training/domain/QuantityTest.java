package com.example.training.domain;

import com.example.training.common.domain.value.Quantity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 数量のテスト
 */
@SpringBootTest
public class QuantityTest {
  /**
   * 数量が生成できる。
   */
  @Test
  void create() {
    Quantity quantity1 = new Quantity(1);
    Quantity quantity2 = new Quantity(9999);
    Assertions.assertEquals(1, quantity1.getValue());
    Assertions.assertEquals(9999, quantity2.getValue());
  }

  /**
   * 数量が加算できる。
   */
  @Test
  void canAdd() {
    /**
     * 1 + 1 = 2
     */
    Quantity q1 = new Quantity(1);
    Quantity q2 = new Quantity(1);
    Quantity res1 = q1.add(q2);
    Assertions.assertEquals(2, res1.getValue());
    /**
     * 2 + 3 = 5
     */
    Quantity q3 = new Quantity(2);
    Quantity q4 = new Quantity(3);
    Quantity res2 = q3.add(q4);
    Assertions.assertEquals(5, res2.getValue());
    /**
     * 1 + 0 = 1
     */
    Quantity q5 = new Quantity(1);
    Quantity q6 = new Quantity(0);
    Quantity res3 = q5.add(q6);
    Assertions.assertEquals(1, res3.getValue());
  }

  /**
   * 数量が減算できる。
   */
  @Test
  void canSubtract() {
    /**
     * 1 - 1 = 0
     */
    Quantity q1 = new Quantity(1);
    Quantity q2 = new Quantity(1);
    Quantity res1 = q1.subtract(q2);
    Assertions.assertEquals(0, res1.getValue());
    /**
     * 5 - 3 = 2
     */
    Quantity q3 = new Quantity(5);
    Quantity q4 = new Quantity(3);
    Quantity res2 = q3.subtract(q4);
    Assertions.assertEquals(2, res2.getValue());
    /**
     * 1 - 2 = 0 (減算結果が負の値の場合、0を返す)
     */
    Quantity q5 = new Quantity(1);
    Quantity q6 = new Quantity(2);
    Quantity res3 = q5.subtract(q6);
    Assertions.assertEquals(0, res3.getValue());
  }

}

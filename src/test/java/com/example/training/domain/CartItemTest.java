package com.example.training.domain;

import com.example.training.common.domain.CartItem;
import com.example.training.common.domain.Product;
import com.example.training.common.domain.value.Price;
import com.example.training.common.domain.value.ProductName;
import com.example.training.common.domain.value.Quantity;
import com.example.training.common.domain.value.id.ProductId;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * カート内商品のテスト
 */
@SpringBootTest
public class CartItemTest {

  /**
   * インスタンスが生成できる。
   */
  @Test
  void testCreate() {
    Product p = new Product(new ProductId(1L), new ProductName("ガム"));
    CartItem cartItem = new CartItem(p);
    Assert.assertEquals(cartItem.getProduct(), p);
    Assert.assertEquals(1, cartItem.getQuantity().getValue());
  }

  /**
   * 商品数が加算できる。
   */
  @Test
  void testAddItem() {
    Product p = new Product(new ProductId(1L), new ProductName("ガム"));
    CartItem cartItem = new CartItem(p);
    /**
     * 1 + 1 = 2
     */
    cartItem.addQuantity(new Quantity(1));
    Assert.assertEquals(2, cartItem.getQuantity().getValue());
    /**
     * 2 + 2 = 4
     */
    cartItem.addQuantity(new Quantity(2));
    Assert.assertEquals(4, cartItem.getQuantity().getValue());
  }

  /**
   * 商品の合計金額が計算できる。
   */
  @Test
  void testGetTotalPrice() {
    Product p = new Product(new ProductId(1L), new ProductName("ガム"), new Price(100));
    CartItem cartItem = new CartItem(p);
    /**
     * 商品の数量を変更できる。 (1 -> 5)
     */
    cartItem.changeQuantity(new Quantity(5));
    Assert.assertEquals(5, cartItem.getQuantity().getValue());
    /**
     * 商品の合計金額が計算できる。(100 * 5 = 500)
     */
    Assert.assertEquals(500, cartItem.getTotalPrice().getValue());
  }

  /**
   * 同じ商品か判定できる。
   */
  @Test
  void testJudgeProductEquals() {
    Product p = new Product(new ProductId(1L), new ProductName("ガム"), new Price(100));
    CartItem cartItem = new CartItem(p);
    Assert.assertTrue(cartItem.equalsProduct(p));
  }

  /**
   * 商品数をゼロにできる。また、商品数がゼロか判定できる。
   */
  @Test
  void testClearQuantity() {
    Product p = new Product(new ProductId(1L), new ProductName("ガム"), new Price(100));
    /**
     * 商品数 5 で生成する。
     */
    CartItem cartItem = new CartItem(p, new Quantity(5));
    Assert.assertEquals(5, cartItem.getQuantity().getValue());
    Assert.assertTrue(!cartItem.isQuantityZero());
    /**
     * 商品数を 0 にして、判定する。
     */
    cartItem.clearQuantity();
    Assert.assertEquals(0, cartItem.getQuantity().getValue());
    Assert.assertTrue(cartItem.isQuantityZero());
  }

}

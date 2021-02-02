package com.example.training.domain;

import com.example.training.common.domain.Cart;
import com.example.training.common.domain.Product;
import com.example.training.common.domain.value.ProductName;
import com.example.training.common.domain.value.id.ProductId;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * カートのテスト
 */
@SpringBootTest
class CartTest {

  /**
   * カートが生成できる。
   */
  @Test
  void create() {
    Cart cart = new Cart();
    Assert.assertNotNull(cart);
  }

  /**
   * カートに商品が追加できる。
   */
  @Test
  void add() {
    Product product = new Product(new ProductId(1L), new ProductName("ガム"));
    Cart cart = new Cart();
    cart.add(product);
    Assert.assertEquals(product, cart.getItem(product).get().getProduct());
  }

  /**
   * カートに商品が指定した数量個、追加できる。
   */
  @Test
  void addWithQuantity() {
    Product product = new Product(new ProductId(1L), new ProductName("ガム"));
    Cart cart = new Cart();
    cart.add(product);
    Assert.assertEquals(1, cart.getItem(product).get().getQuantity().getValue());
  }

  // /**
  // * カートから商品を削除できる。
  // */
  // @Test
  // void remove() {
  // Product product = new Product(new ProductId(1L), new ProductName("ガム"));
  // Cart cart = new Cart();
  // cart.add(product);
  // assertEquals(1, cart.getSize());
  // cart.remove(product);
  // assertEquals(0, cart.getSize());
  // cart.remove(product);
  // assertEquals(0, cart.getSize());
  // }

  // /**
  // *
  // */
  // @Test
  // void list() {
  // Product product = new Product(new ProductId(1L), new ProductName("ガム"));
  // Product product2 = new Product(new ProductId(2L), new ProductName("チョコ"));
  // Cart cart = new Cart();
  // cart.add(product);

  // List<CartItem> products = cart.getItems();
  // assertNotNull(products);
  // assertEquals(1, products.size());

  // cart.add(product2);
  // List<CartItem> products2 = cart.getItems();
  // assertEquals(2, products2.size());

  // cart.add(product);
  // cart.add(product);
  // Optional<CartItem> itemOpt = cart.getItem(product);
  // assertTrue(itemOpt.isPresent());
  // CartItem item = itemOpt.get();
  // assertEquals(3, item.getQuantity());
  // cart.add(product, new Quantity(3));
  // assertEquals(6, item.getQuantity());
  // }

  // /**
  // * カート内商品の合計金額が計算できる。
  // */
  // @Test
  // void totalPrice() {
  // Product product1 = new Product(new ProductId(1L), new ProductName("ガム"), new
  // Price(20));
  // Product product2 = new Product(new ProductId(2L), new ProductName("チョコ"), new
  // Price(200));
  // Cart cart = new Cart();
  // cart.add(product1);
  // assertEquals(20, cart.getTotalPrice());
  // cart.add(product1);
  // cart.add(product1);
  // assertEquals(60, cart.getTotalPrice());
  // cart.add(product2);
  // assertEquals(160, cart.getTotalPrice());
  // }
}

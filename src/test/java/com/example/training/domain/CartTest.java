package com.example.training.domain;

import java.util.Optional;

import com.example.training.common.domain.Cart;
import com.example.training.common.domain.Product;
import com.example.training.common.domain.value.Price;
import com.example.training.common.domain.value.ProductName;
import com.example.training.common.domain.value.Quantity;
import com.example.training.common.domain.value.id.ProductId;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * カートのテスト
 */
@SpringBootTest
class CartTest {

  @BeforeAll
  public void setUp() {
  }

  /**
   * カートが生成できる。
   */
  @Test
  void canCreate() {
    Cart cart = new Cart();
    Assertions.assertNotNull(cart);
  }

  /**
   * カートに商品が追加できる。
   */
  @Test
  void canAddProduct() {
    Product p = new Product(new ProductId(1L), new ProductName("ガム"));
    Cart cart = new Cart();
    cart.add(p);
    Assertions.assertEquals(p, cart.getItem(p).get().getProduct());
  }

  /**
   * カートに商品が指定した数量個、追加できる。
   */
  @Test
  void canAddProductWithQuantity() {
    Product p = new Product(new ProductId(1L), new ProductName("ガム"));
    Cart cart = new Cart();
    /**
     * 空のカートに商品を5つ追加する。
     */
    cart.add(p, new Quantity(5));
    Assertions.assertEquals(5, cart.getItem(p).get().getQuantity().getValue());
    /**
     * 同じ商品をさらに5つ追加する。
     */
    cart.add(p, new Quantity(5));
    Assertions.assertEquals(10, cart.getItem(p).get().getQuantity().getValue());
  }

  /**
   * カートから商品を削除できる。
   */
  @Test
  void canRemoveProduct() {
    Product p = new Product(new ProductId(1L), new ProductName("ガム"));
    Cart cart = new Cart();
    cart.add(p);

    /**
     * １つ追加して削除する。
     */
    Assertions.assertEquals(1, cart.getSize());
    cart.remove(p);
    Assertions.assertEquals(0, cart.getSize());
    cart.remove(p);
    Assertions.assertEquals(0, cart.getSize());
    /**
     * 5つ追加して削除する。
     */
    cart.add(p, new Quantity(5));
    cart.remove(p);
    Assertions.assertEquals(0, cart.getSize());
    Assertions.assertEquals(Optional.empty(), cart.getItem(p));
  }

  /**
   * 商品数が変更できる。
   */
  @Test
  void canChangeItemQuantity() {
    Product p = new Product(new ProductId(1L), new ProductName("ガム"));
    Cart cart = new Cart();
    cart.add(p);

    /**
     * 商品数を 1 から 5 に変更
     */
    cart.changeItemQuantity(p, new Quantity(5));
    Assertions.assertEquals(5, cart.getItem(p).get().getQuantity().getValue());

  }

  /**
   * カート内商品の合計金額が計算できる。
   */
  @Test
  void canGetTotalPrice() {
    Product p1 = new Product(new ProductId(1L), new ProductName("ガム"), new Price(100));
    Product p2 = new Product(new ProductId(2L), new ProductName("チョコ"), new Price(200));
    Cart cart = new Cart();
    /**
     * 100
     */
    cart.add(p1);
    Assertions.assertEquals(100, cart.getTotalPrice());
    /**
     * 100 + 200 = 300
     */
    cart.add(p2);
    Assertions.assertEquals(300, cart.getTotalPrice());
    /**
     * 300 + 100 + 200 = 600
     */
    cart.add(p1);
    cart.add(p2);
    Assertions.assertEquals(600, cart.getTotalPrice());
  }

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

}

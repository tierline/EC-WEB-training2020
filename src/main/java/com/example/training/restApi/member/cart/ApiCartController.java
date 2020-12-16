package com.example.training.restApi.member.cart;

import javax.servlet.http.HttpSession;

import com.example.training.common.domain.Cart;
import com.example.training.common.domain.Product;
import com.example.training.common.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/member/cart")
public class ApiCartController {

  @Autowired
  private HttpSession session;

  @Autowired
  private ProductRepository productRepository;

  /**
   * @return カートに商品の追加
   */
  @PostMapping("/add/{id}")
  public String add(@PathVariable int id) {
    Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
    Product product = productRepository.findId(id).orElseThrow();
    cart.add(product);

    session.setAttribute(Cart.SESSION_NAME, cart);
    return "id番号" + id + "の商品" + product + "をカートに保存しました";
  }

  /**
   * @param id
   * @return カート内の商品の削除
   */
  @PostMapping("/delete/{id}")
  public String delete(@PathVariable int id) {
    Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
    Product product = productRepository.findId(id).orElseThrow();
    cart.remove(product);

    return "id番号" + id + "の商品" + product + "をカートから削除しました";
  }

  /**
   * @return セッション情報を見る
   */
  @GetMapping("/show")
  public Object show() {
    Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
    return cart;
  }
}

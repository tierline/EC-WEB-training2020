package com.example.training.restApi.member.order;

import javax.servlet.http.HttpSession;

import com.example.training.common.domain.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/member/order")
public class ApiOrderController {

  @Autowired
  private HttpSession session;

  @Autowired
  private OrderService orderService;

  /**
   * 注文処理を行う
   */
  @PostMapping("/save")
  public String save() {
    return "注文処理を行いました 住所は...";
  }

  // /**
  // * 注文処理を行う
  // */
  // @PostMapping("/save")
  // public String save(@ModelAttribute("orderForm") @Valid OrderForm orderForm,
  // BindingResult result, Model model) {
  // if (result.hasErrors()) {
  // return form(orderForm, model);
  // } else {
  // Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
  // int orderId = orderService.order(orderForm, cart);
  // session.setAttribute(Cart.SESSION_NAME, new Cart());
  // return "redirect:/member/order/complete/" + orderId;
  // }
  // }

}

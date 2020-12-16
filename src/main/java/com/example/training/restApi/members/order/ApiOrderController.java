package com.example.training.restApi.members.order;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.example.training.common.domain.OrderForm;
import com.example.training.common.domain.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class ApiOrderController {

  @Autowired
  private HttpSession session;

  @Autowired
  private OrderService orderService;

  /**
   * 注文処理を行う
   */
  @PostMapping("/api/members/order/save")
  public String save(@ModelAttribute("orderForm") @Valid OrderForm orderForm, BindingResult result, Model model) {
    return "注文処理を行いました";
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
  // return "redirect:/members/order/complete/" + orderId;
  // }
  // }

}

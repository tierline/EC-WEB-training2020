package com.example.training.common.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.training.common.domain.Cart;
import com.example.training.common.domain.OrderForm;
import com.example.training.common.service.OrderService;
import com.example.training.member.domain.Member;

@Controller
@RequestMapping("/member/order")
public class OrderController {

	@Autowired
	private HttpSession session;

	@Autowired
	private OrderService orderService;

	/**
	 * 住所入力フォームに遷移
	 */
	@GetMapping("/form")
	public String form(OrderForm orderForm, Model model) {
		Member member = (Member) session.getAttribute(Member.SESSION_NAME);
		OrderForm sessionOrderForm = (OrderForm) session.getAttribute(OrderForm.SESSION_NAME);
		if (sessionOrderForm != null) {
			model.addAttribute("orderForm", sessionOrderForm);
		} else {
			orderForm.setMemberInfo(member);
		}
		return "member/order/form";
	}

	// 注文内容確認画面を表示する
	@PostMapping("/confirmation")
	public String confirmation(@Valid OrderForm orderForm, BindingResult result, Model model) {
		session.setAttribute(OrderForm.SESSION_NAME, orderForm);
		if (result.hasErrors()) {
			return form(orderForm, model);
		} else {
			Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
//			List<CartItem> items = cart.getItems();
//			int totalAmount = cart.getTotalAmount();
			// cart を返したらいけるかも。
//			model.addAttribute("items", items);
//			model.addAttribute("totalAmount", totalAmount);

			model.addAttribute("cart", cart);
			model.addAttribute("orderForm", orderForm);
			return "member/order/confirmation";
		}
	}

	/**
	 * 注文を処理する
	 */
	@PostMapping("/save")
	public String save() {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		OrderForm orderForm = (OrderForm) session.getAttribute(OrderForm.SESSION_NAME);
		int orderId = orderService.order(orderForm, cart);
		session.setAttribute(Cart.SESSION_NAME, new Cart());
		session.removeAttribute(OrderForm.SESSION_NAME);
		return "redirect:/member/order/complete/" + orderId;
	}

	/**
	 * 注文完了画面
	 */
	@GetMapping("/complete/{orderId}")
	public String complete(@PathVariable int orderId, Model model) {
		model.addAttribute("orderId", orderId);
		return "member/order/complete";
	}
}

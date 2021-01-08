package com.example.training.common.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.example.training.common.domain.Cart;
import com.example.training.common.domain.CartItem;
import com.example.training.common.domain.Order;
import com.example.training.common.domain.OrderForm;
import com.example.training.common.domain.OrderItem;
import com.example.training.common.domain.OrderService;
import com.example.training.common.repository.OrderRepository;
import com.example.training.member.domain.Member;
import com.example.training.member.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/order")
public class OrderController {

	@Autowired
	private HttpSession session;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderService orderService;

	/**
	 * 注文詳細と住所入力フォームに遷移
	 */
	@GetMapping("/form")
	public String form(OrderForm orderForm, Model model, BindingResult result) {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		Member member = (Member) session.getAttribute(Member.SESSION_NAME);
		OrderForm sessionOrderForm = (OrderForm) session.getAttribute(OrderForm.SESSION_NAME);
		if (session.getAttribute(OrderForm.SESSION_NAME) == null || result.hasErrors()) {
			model.addAttribute("orderForm", orderForm);
			orderForm.setMemberInfo(member);
		} else {
			model.addAttribute("orderForm", sessionOrderForm);
		}
		model.addAttribute("cart", cart);
		return "member/order/form";
	}

	// 注文内容確認画面を表示する
	@PostMapping("/confirmation")
	public String confirmation(@Valid OrderForm orderForm, BindingResult result, Model model) {
		session.setAttribute(OrderForm.SESSION_NAME, orderForm);
		if (result.hasErrors()) {
			return form(orderForm, model, result);
		} else {
			Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
			List<CartItem> items = cart.getItems();
			int totalAmount = cart.getTotalAmount();
			model.addAttribute("items", items);
			model.addAttribute("totalAmount", totalAmount);
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
		memberRepository.updateAtOrder(orderForm);
		session.setAttribute(Member.SESSION_NAME, memberRepository.findById(orderForm.getMemberId()));
		session.setAttribute(Cart.SESSION_NAME, new Cart());
		session.removeAttribute(OrderForm.SESSION_NAME);
		return "redirect:/member/order/complete/" + orderId;
	}

	/**
	 * 注文明細画面
	 */
	@GetMapping("/complete/{id}")
	public String complete(@PathVariable int id, Model model) {
		Order order = orderRepository.findById(id);
		List<OrderItem> items = orderRepository.findItemsByOrder(order);
		model.addAttribute("order", order);
		model.addAttribute("items", items);
		return "member/order/complete";
	}
}

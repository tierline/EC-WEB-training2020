package com.example.training.web.controller;

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

import com.example.training.common.repository.MemberRepository;
import com.example.training.web.domain.cart.Cart;
import com.example.training.web.domain.member.Email;
import com.example.training.web.domain.member.Member;
import com.example.training.web.domain.member.MemberEntity;
import com.example.training.web.domain.member.MemberSession;
import com.example.training.web.domain.order.Order;
import com.example.training.web.domain.order.OrderForm;
import com.example.training.web.domain.service.OrderService;

@Controller
@RequestMapping("/member/order")
public class OrderController {

	@Autowired
	private HttpSession session;

	@Autowired
	private OrderService orderService;

	@Autowired
	private MemberRepository memberRepository;

	/**
	 *
	 * お届け先入力フォームを表示する
	 *
	 * @param orderForm
	 * @param model
	 * @return お届け先入力フォーム画面
	 */
	@GetMapping("/form")
	public String form(OrderForm orderForm, Model model) {
		MemberSession memberSession = (MemberSession) session.getAttribute(Member.SESSION_NAME);
		OrderForm sessionOrderForm = (OrderForm) session.getAttribute(OrderForm.SESSION_NAME);
		if (sessionOrderForm != null) {
			model.addAttribute("orderForm", sessionOrderForm);
		} else {
			Email email = new Email(memberSession.getEmail());
			MemberEntity entity = memberRepository.findByEmail(email).orElseThrow();
			orderForm.setMemberInfo(entity);
			session.setAttribute(OrderForm.SESSION_NAME, orderForm);
		}
		return "member/order/form";
	}

	/**
	 *
	 * 注文確認画面を表示する
	 *
	 * @param orderForm
	 * @param result
	 * @param model
	 * @return 注文確認画面
	 */
	@PostMapping("/confirmation")
	public String confirmation(@Valid OrderForm orderForm, BindingResult result, Model model) {
		session.setAttribute(OrderForm.SESSION_NAME, orderForm);
		if (result.hasErrors()) {
			return form(orderForm, model);
		} else {
			Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
			model.addAttribute("cart", cart);
			model.addAttribute("orderForm", orderForm);
			return "member/order/confirmation";
		}
	}

	/**
	 *
	 * 注文を処理する
	 *
	 * @return 注文完了画面
	 */
	@PostMapping("/save")
	public String save() {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		OrderForm orderForm = (OrderForm) session.getAttribute(OrderForm.SESSION_NAME);
		Order order = orderService.order(orderForm, cart);
		// メンバーのリロード処理を追加
		session.setAttribute(Cart.SESSION_NAME, new Cart());
		session.removeAttribute(OrderForm.SESSION_NAME);
		return "redirect:/member/order/complete/" + order.getOrderId();
	}

	/**
	 *
	 * 注文完了画面を表示する
	 *
	 * @param orderId
	 * @param model
	 * @return 注文完了画面
	 */
	@GetMapping("/complete/{orderId}")
	public String complete(@PathVariable int orderId, Model model) {
		model.addAttribute("orderId", orderId);
		return "member/order/complete";
	}
}

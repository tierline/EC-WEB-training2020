package com.example.training.web.controller.order;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.example.training.common.controller.CartDTO;
import com.example.training.common.controller.MemberDTO;
import com.example.training.common.controller.OrderSaveCommand;
import com.example.training.common.domain.Cart;
import com.example.training.common.domain.Member;
import com.example.training.common.domain.Order;
import com.example.training.common.domain.value.Email;
import com.example.training.common.entity.MemberEntity;
import com.example.training.common.http.MemberSession;
import com.example.training.common.repository.MemberRepository;
import com.example.training.common.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 注文のコントローラ
 */
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
	 * お届け先入力フォームを表示する。
	 *
	 * @param orderSaveCommand
	 * @param model
	 * @return お届け先入力フォーム画面
	 */
	@GetMapping("/form")
	public String form(OrderSaveCommand orderSaveCommand, Model model) {
		/**
		 * TODO: セッション情報から会員のインスタンスを生成するまでが長い
		 */
		MemberSession memberSession = (MemberSession) session.getAttribute(Member.SESSION_NAME);
		Email email = memberSession.getEmail();
		MemberEntity memberEntity = memberRepository.findByEmail(email).orElseThrow(NullPointerException::new);
		Member member = new Member(memberEntity);
		OrderSaveCommand sessionOrderSaveCommand = (OrderSaveCommand) session.getAttribute(OrderSaveCommand.SESSION_NAME);
		if (sessionOrderSaveCommand != null) {
			model.addAttribute("orderSaveCommand", sessionOrderSaveCommand);
		} else {
			MemberDTO memberDto = new MemberDTO(member);
			orderSaveCommand.setMemberInfo(memberDto);
			session.setAttribute(OrderSaveCommand.SESSION_NAME, orderSaveCommand);
		}
		return "member/order/form";
	}

	/**
	 * 注文確認画面を表示する。
	 *
	 * @param orderSaveCommand
	 * @param result
	 * @param model
	 * @return 注文確認画面
	 */
	@PostMapping("/confirmation")
	public String confirmation(@Valid OrderSaveCommand orderSaveCommand, BindingResult result, Model model) {
		session.setAttribute(OrderSaveCommand.SESSION_NAME, orderSaveCommand);
		if (result.hasErrors()) {
			return form(orderSaveCommand, model);
		} else {
			Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
			CartDTO cartDTO = new CartDTO(cart);
			model.addAttribute("cart", cartDTO);
			model.addAttribute("orderSaveCommand", orderSaveCommand);
			return "member/order/confirmation";
		}
	}

	/**
	 * 注文処理する。
	 *
	 * @return 注文完了画面
	 */
	@PostMapping("/save")
	public String save() {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		OrderSaveCommand orderSaveCommand = (OrderSaveCommand) session.getAttribute(OrderSaveCommand.SESSION_NAME);
		Order order = orderSaveCommand.createOrderFrom(cart);
		Order ordered = orderService.order(order, cart);
		session.setAttribute(Cart.SESSION_NAME, new Cart());
		session.removeAttribute(OrderSaveCommand.SESSION_NAME);
		return "redirect:/member/order/complete/" + ordered.getId().getValue();
	}

	/**
	 * 注文完了画面を表示する。
	 *
	 * @param orderId
	 * @param model
	 * @return 注文完了画面
	 */
	@GetMapping("/complete/{orderId}")
	public String complete(@PathVariable String orderId, Model model) {
		model.addAttribute("orderId", orderId);
		return "member/order/complete";
	}
}

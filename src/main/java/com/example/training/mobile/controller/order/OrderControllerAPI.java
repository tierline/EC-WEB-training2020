package com.example.training.mobile.controller.order;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.example.training.common.controller.OrderDTO;
import com.example.training.common.controller.OrderSaveCommand;
import com.example.training.common.domain.Cart;
import com.example.training.common.domain.Member;
import com.example.training.common.domain.Order;
import com.example.training.common.domain.value.Email;
import com.example.training.common.domain.value.id.OrderId;
import com.example.training.common.entity.MemberEntity;
import com.example.training.common.entity.OrderItemEntity;
import com.example.training.common.http.MemberSession;
import com.example.training.common.repository.MemberRepository;
import com.example.training.common.repository.OrderRepository;
import com.example.training.common.service.OrderService;
import com.example.training.web.controller.order.OrderHistoryAssembler;
import com.example.training.web.controller.order.OrderHistoryByMonth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注文のコントローラ(Mobile)
 */
@CrossOrigin
@RestController
@RequestMapping("/api/member/order")
public class OrderControllerAPI {

	@Autowired
	private HttpSession session;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderService orderService;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private OrderHistoryAssembler orderHistoryAssembler;

	/**
	 * 注文処理を行う
	 */

	@PostMapping("/save")
	public OrderDTO save(@RequestBody OrderSaveCommand orderSaveCommand) {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		Order order = new Order(orderSaveCommand, cart);
		Order ordered = orderService.order(order, cart);
		OrderDTO orderDTO = new OrderDTO(ordered);
		session.setAttribute(Cart.SESSION_NAME, new Cart());
		return orderDTO;
	}

	/**
	 * 注文番号から注文"明細"を返す
	 */
	@GetMapping("/orderDetails/{id}")
	public Order orderDetails(@PathVariable Long id) {
		OrderId orderId = new OrderId(id);
		Order order = orderRepository.findById(orderId);

		return order;
	}

	/**
	 * 注文番号から注文"商品"を返す
	 */
	@GetMapping("/orderedItemList/{id}")
	public List<OrderItemEntity> orderedItemList(@PathVariable Long id) {
		OrderId orderId = new OrderId(id);
		List<OrderItemEntity> items = orderRepository.findOrderItemsById(orderId);

		return items;
	}

	@GetMapping("/history/item/{id}")
	public List<OrderItemEntity> orderItemList(@PathVariable Long id) {
		OrderId orderId = new OrderId(id);
		List<OrderItemEntity> list = orderRepository.findOrderItemsById(orderId);
		return list;
	}

	/**
	 * 会員の購入履歴を取得する
	 *
	 * @return 月毎の購入履歴
	 */
	@GetMapping("/history")
	public Map<Integer, List<OrderHistoryByMonth>> history() {
		MemberSession memberSession = (MemberSession) session.getAttribute(Member.SESSION_NAME);
		Email email = memberSession.getEmail();
		MemberEntity memberEntity = memberRepository.findByEmail(email).orElseThrow(NullPointerException::new);
		Member member = new Member(memberEntity);
		Map<Integer, List<OrderHistoryByMonth>> result = orderHistoryAssembler.create(member);
		return result;
	}

}

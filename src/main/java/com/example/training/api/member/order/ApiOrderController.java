package com.example.training.api.member.order;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.training.common.domain.Cart;
import com.example.training.common.domain.Order;
import com.example.training.common.domain.OrderForm;
import com.example.training.common.domain.OrderHistoryAssembler;
import com.example.training.common.domain.OrderItem;
import com.example.training.common.domain.OrderMonth;
import com.example.training.common.domain.OrderService;
import com.example.training.common.repository.OrderRepository;
import com.example.training.member.domain.Member;
import com.example.training.member.repository.MemberRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/member/order")
public class ApiOrderController {

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
	public Integer save(@RequestBody OrderForm order) {
		Member member = (Member) session.getAttribute(Member.SESSION_NAME);
		int memberId = member.getId();
		OrderForm orderForm = new OrderForm(order, memberId);
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		int orderId = orderService.order(orderForm, cart);
		memberRepository.updateAtOrder(orderForm);
		session.setAttribute(Cart.SESSION_NAME, new Cart());

		return orderId;
	}

	/**
	 * 注文番号から注文明細を返す
	 */
	@GetMapping("/orderDetails/{id}")
	public Order orderDetails(@PathVariable Integer id) {
		Order order = orderRepository.findById(id);

		return order;
	}

	/**
	 * 注文番号から注文明細を返す
	 */
	@GetMapping("/orderedItemList/{id}")
	public List<OrderItem> orderedItemList(@PathVariable Integer id) {
		Order order = orderRepository.findById(id);
		List<OrderItem> items = orderRepository.findItemsByOrder(order);

		return items;

	}

	// 変数名かえる
	// dataの受け取り方微妙？
	@PostMapping("/history")
	@ResponseBody
	public Map<Integer, List<OrderMonth>> history(@RequestBody Member member) {
		Optional<Member> memberId = memberRepository.findByEmail(member.getEmail());
		int id = memberId.get().getId();
		List<OrderMonth> list = orderRepository.findByOrderMonth(id);
		Map<Integer, List<OrderMonth>> result = orderHistoryAssembler.create(list);
		return result;
	}

	@GetMapping("/history/item/{id}")
	public List<OrderItem> orderItemList(@PathVariable int id) {
		List<OrderItem> list = orderRepository.findByOrderItem(id);
		return list;
	}
}

package com.example.training.api.member.order;

import java.time.LocalDate;
import java.util.LinkedHashMap;
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

import com.example.training.common.domain.Order;
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

	/*
	 * 住所情報があったら表示する
	 */
	@GetMapping("/{id}")
	public Member order(@PathVariable int id) {
		Member member = memberRepository.findByAddress(id);
		return member;
	}

	/**
	 * 注文処理を行う
	 */
	@PostMapping("/save")
	public Integer save(@RequestBody LinkedHashMap<String, String> order) {

		String lastName = order.get("lastName");
		String firstName = order.get("firstName");
		String email = order.get("email");
		String phone = order.get("phone");
		String address1 = order.get("address1");
		String address2 = order.get("address2");
		LocalDate dateNow = LocalDate.now();
		Member member = (Member) session.getAttribute(Member.SESSION_NAME);
		int memberId = member.getId();

//		 OrderForm orderForm = new OrderForm(lastName, firstName, email, phone,
//		 address1, address2, memberId, dateNow;)0
//		 Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
//		 int orderId = orderService.order(orderForm, cart);
//		 session.setAttribute(Cart.SESSION_NAME, new Cart());

		return 0;
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

	@PostMapping("/member_id")
	@ResponseBody
	public int history(@RequestBody Member member) {
		Optional<Member> memberId = memberRepository.findByEmail(member.getEmail());
		if (memberId.isPresent()) {
		}
		int id = memberId.get().getId();
		return id;
	}

	@GetMapping("/history/item/{id}")
	public List<OrderItem> orderItemList(@PathVariable int id) {
		List<OrderItem> list = orderRepository.findByOrderItem(id);
		return list;
	}

	@GetMapping("/history/{id}")
	public Map<Integer, List<OrderMonth>> orderList(@PathVariable int id) {
		List<OrderMonth> list = orderRepository.findByOrderMonth(id);
		Map<Integer, List<OrderMonth>> result = orderHistoryAssembler.create(list);

		return result;
	}

}

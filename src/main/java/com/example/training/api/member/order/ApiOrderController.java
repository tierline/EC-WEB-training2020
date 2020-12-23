package com.example.training.api.member.order;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import com.example.training.common.domain.Cart;
import com.example.training.common.domain.Order;
import com.example.training.common.domain.OrderForm;
import com.example.training.common.domain.OrderHistory;
import com.example.training.common.domain.OrderItem;
import com.example.training.common.domain.OrderService;
import com.example.training.common.repository.OrderRepository;
import com.example.training.member.domain.Member;
import com.example.training.member.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
		Date dateNow = new Date();
		Member member = (Member) session.getAttribute(Member.SESSION_NAME);
		int memberId = member.getId();

		OrderForm orderForm = new OrderForm(lastName, firstName, email, phone, address1, address2, memberId, dateNow);

		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		int orderId = orderService.order(orderForm, cart);
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
	@GetMapping("/itemDetails/{id}")
	public List<OrderItem> itemDetails(@PathVariable Integer id) {
		Order order = orderRepository.findById(id);
		List<OrderItem> items = orderRepository.findItemsByOrder(order);

		return items;

	}

	@PostMapping("/history")
	@ResponseBody
	public List<OrderHistory> history(@RequestBody Member member) {
		Optional<Member> memberId = memberRepository.findByEmail(member.getEmail());
		if (memberId.isEmpty()) {
		}
		int id = memberId.get().getId();
		List<OrderHistory> list = orderRepository.findByOrderDate(id);
		return list;
	}

	@GetMapping("/history/{id}")
	public List<OrderHistory> itemHistory(@PathVariable Integer id) {
		List<OrderHistory> list = orderRepository.findItemByOrderHistory(id);
		return list;
	}

//	@GetMapping("/history/{id}")
//	@ResponseBody
//	public List<OrderHistory> fetch(@PathVariable Integer id) {
//		List<OrderHistory> list = orderRepository.findItemByOrderHistory(id);
//		return list;
//	}
}

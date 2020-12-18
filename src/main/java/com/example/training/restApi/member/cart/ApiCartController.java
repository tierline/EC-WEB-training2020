package com.example.training.restApi.member.cart;

import javax.servlet.http.HttpSession;

import com.example.training.common.domain.Cart;
import com.example.training.common.domain.Product;
import com.example.training.common.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/member/cart")
public class ApiCartController {

	@Autowired
	private HttpSession session;

	@Autowired
	private ProductRepository productRepository;

	/**
	 * @return カートに商品の追加
	 */
	@PostMapping("/add/{id}")
	public void add(@PathVariable int id) {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		Product product = productRepository.findId(id).orElseThrow();
		cart.add(product);
	}

	/**
	 * @param id
	 * @return カート内の商品の削除を削除する
	 */
	@PostMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		Product product = productRepository.findId(id).orElseThrow();
		cart.removeAll(product);
	}

	/**
	 * @return カート内の商品を表示する
	 */
	@GetMapping("/list")
	public Object list() {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		return cart;
	}

	/**
	 * @return カートに商品がないか確認する
	 */
	@GetMapping("/hasItem")
	public Boolean cartHasItem() {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		if (0 < cart.getSize()) {
			return true;
		} else {
			return false;
		}
	}
}

package com.example.training.restApi;

import java.util.List;

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
@RequestMapping("/api")
public class RestApiController {

	@Autowired
	private HttpSession session;

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/products")
	public List<Product> product() {
		List<Product> items = productRepository.findAll();
		return items;
	}

	/**
	 * @return カートに商品の追加
	 */
	@PostMapping("/cart/add/{id}")
	public String add(@PathVariable int id) {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		Product product = productRepository.findId(id).orElseThrow();
		cart.add(product);

		session.setAttribute(Cart.SESSION_NAME, cart);
		return "id番号" + id + "の商品" + product + "をカートに保存しました";
	}

	/**
	 * @return セッション情報を見る
	 */
	@GetMapping("/cart/show")
	public Object show() {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		return cart;
	}
}

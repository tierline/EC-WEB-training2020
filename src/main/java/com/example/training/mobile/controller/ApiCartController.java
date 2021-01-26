package com.example.training.mobile.controller;

import javax.servlet.http.HttpSession;

import com.example.training.common.repository.ProductRepository;
import com.example.training.web.domain.cart.Cart;
import com.example.training.web.domain.product.Product;
import com.example.training.web.domain.product.ProductEntity;
import com.example.training.web.domain.product.Quantity;

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
	 * カートを得る。
	 *
	 * @return カート
	 */
	@GetMapping("/")
	public Cart getCart() {
		Cart cartEntity = (Cart) session.getAttribute(Cart.SESSION_NAME);
		return cartEntity;
	}

	/**
	 * カートに商品の追加する。
	 *
	 * @return
	 */
	@PostMapping("/add/{productId}")
	public void add(@PathVariable int productId) {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		ProductEntity productEntity = productRepository.findId(productId).orElseThrow();
		Product product = new Product(productEntity);
		cart.add(product);
	}

	// fix
	/**
	 * カートの商品の数量を変更する。
	 *
	 * @param id
	 * @return
	 */
	@PostMapping("/changeQuantity/{productId}/{quantity}")
	public void changeItemQuantity(@PathVariable int productId, @PathVariable int quantity) {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		ProductEntity productEntity = productRepository.findId(productId).orElseThrow();
		Product product = new Product(productEntity);
		cart.changeItemQuantity(product, new Quantity(quantity));
	}

	/**
	 * カートから特定の商品をすべて削除する。
	 *
	 * @param id
	 * @return
	 */
	@PostMapping("/remove/{productId}")
	public Cart cartFromParticularProductsAllDelete(@PathVariable int productId) {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		ProductEntity productEntity = productRepository.findId(productId).orElseThrow();
		Product product = new Product(productEntity);
		cart.removeAll(product);
		return cart;
	}

	/**
	 * カートに商品がないか確認する。
	 *
	 * @return
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

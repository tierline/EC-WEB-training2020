package com.example.training.mobile.controller.cart;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.training.common.domain.Cart;
import com.example.training.common.domain.Product;
import com.example.training.common.domain.value.Quantity;
import com.example.training.common.entity.ProductEntity;
import com.example.training.common.repository.ProductRepository;

/**
 * カートコントローラ(Mobile)
 */
@CrossOrigin
@RestController
@RequestMapping("/api/member/cart")
public class CartControllerAPI {

	@Autowired
	private HttpSession session;

	@Autowired
	private ProductRepository productRepository;

	/**
	 * カートを取得する。
	 *
	 * @return カート
	 */
	@GetMapping("/")
	public CartDTO getCart() {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		CartDTO cartDTO = new CartDTO(cart);
		return cartDTO;
	}

	/**
	 * カートに商品の追加する。
	 *
	 * @return
	 */
	@PostMapping("/add/{productId}")
	public void add(@PathVariable int productId) {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		ProductEntity productEntity = productRepository.findById(productId).orElseThrow();
		Product product = new Product(productEntity);
		cart.add(product);
	}

	/**
	 * カートの商品の数量を変更する。
	 *
	 * @param id
	 * @return
	 */
	@PostMapping("/changeQuantity/{productId}/{quantity}")
	public void changeItemQuantity(@PathVariable int productId, @PathVariable int quantity) {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		ProductEntity productEntity = productRepository.findById(productId).orElseThrow();
		Product product = new Product(productEntity);
		cart.changeItemQuantity(product, new Quantity(quantity));
	}

	/**
	 * カートから特定の商品をすべて削除する。
	 *
	 * @param productId
	 * @return
	 */
	@PostMapping("/remove/{productId}")
	public Cart cartFromParticularProductsAllDelete(@PathVariable int productId) {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		ProductEntity productEntity = productRepository.findById(productId).orElseThrow();
		Product product = new Product(productEntity);
		cart.remove(product);
		return cart;
	}
}

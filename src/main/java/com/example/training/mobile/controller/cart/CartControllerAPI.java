package com.example.training.mobile.controller.cart;

import javax.servlet.http.HttpSession;

import com.example.training.common.controller.CartDTO;
import com.example.training.common.domain.Cart;
import com.example.training.common.domain.Product;
import com.example.training.common.domain.value.Quantity;
import com.example.training.common.domain.value.id.ProductId;
import com.example.training.common.entity.ProductEntity;
import com.example.training.common.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	@PostMapping("/add/{id}")
	public void add(@PathVariable Long id) {
		ProductId productId = new ProductId(id);
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		ProductEntity productEntity = productRepository.findById(productId).orElseThrow(NullPointerException::new);
		Product product = new Product(productEntity);
		cart.add(product);
	}

	/**
	 * カートの商品の数量を変更する。
	 *
	 * @param id
	 */
	@PostMapping("/changeQuantity/{id}/{quantity}")
	public void changeItemQuantity(@PathVariable Long id, @PathVariable int quantity) {
		ProductId productId = new ProductId(id);
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		ProductEntity productEntity = productRepository.findById(productId).orElseThrow(NullPointerException::new);
		Product product = new Product(productEntity);
		cart.changeItemQuantity(product, new Quantity(quantity));
	}

	/**
	 * カートから特定の商品をすべて削除する。
	 *
	 * @param productId
	 */
	@PostMapping("/remove/{id}")
	public Cart cartFromParticularProductsAllDelete(@PathVariable Long id) {
		ProductId productId = new ProductId(id);
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		ProductEntity productEntity = productRepository.findById(productId).orElseThrow(NullPointerException::new);
		Product product = new Product(productEntity);
		cart.remove(product);
		return cart;
	}
}

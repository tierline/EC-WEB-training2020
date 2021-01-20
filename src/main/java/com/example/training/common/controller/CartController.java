package com.example.training.common.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import com.example.training.common.domain.Cart;
import com.example.training.common.domain.Product;
import com.example.training.common.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author
 *
 */
@Controller
@RequestMapping("/member/cart")
public class CartController {
	@Autowired
	protected HttpSession session;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	protected MessageSource messageSource;

	/**
	 *
	 * カートに商品を1つ追加する
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/add/{id}")
	public String add(@PathVariable int id) {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		Product product = productRepository.findId(id).orElseThrow();
		cart.add(product);
		return "redirect:/";
	}

	/**
	 *
	 * カートに商品を1つ追加する
	 *
	 * @param id
	 * @return
	 */
	@PostMapping(path = "/addPost/{id}", consumes = "application/x-www-form-urlencoded")
	public String addPost(@PathVariable int id, int quantity) {
		System.out.println(id);
		System.out.println(quantity);
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		Product product = productRepository.findId(id).orElseThrow();
		cart.changeItemQuantity(product, quantity);
		return "redirect:/member/cart/list";
	}

	// /**
	// *
	// * カートに商品を1つ追加する
	// *
	// * @param id
	// * @return
	// */
	// @PostMapping("/addPost/{id}/{quantity}")
	// public String addPost(@PathVariable int id, @PathVariable int quantity) {
	// System.out.println(id);
	// System.out.println(quantity);
	// Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
	// Product product = productRepository.findId(id).orElseThrow();
	// cart.add(product);
	// return "redirect:/member/cart/list";
	// }

	/**
	 *
	 * カート内の商品を1つ削除する
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		Product product = productRepository.findId(id).orElseThrow();
		cart.remove(product);

		return "redirect:/member/cart/list";
	}

	/**
	 *
	 * カート内商品の一覧画面を表示する
	 *
	 */
	@GetMapping("/list")
	public String doGet(Model model) {
		Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
		if (cart.getSize() == 0) {
			model.addAttribute("errorMessage", messageSource.getMessage("error.cart.noProduct", null, Locale.JAPAN));
		}
		model.addAttribute("cart", cart);
		return "member/cart";
	}
}

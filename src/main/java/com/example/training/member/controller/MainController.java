package com.example.training.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.training.member.domain.Product;
import com.example.training.member.repository.ProductRepository;

@Controller
public class MainController {
	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/")
	public String index(Model model) {
		List<Product> products = productRepository.findAll();
		model.addAttribute("products", products);
		return "index";
	}

	@GetMapping("/cart")
	public String cart(Model model) {
		return "cart";
	}

	@GetMapping("/product")
	public String product(Model model) {
		return "product";
	}

	/**
	 * フリーワード検索
	 * 
	 * @param model
	 * @param word
	 * @return
	 */
	@PostMapping("/search")
	public String search(Model model, @RequestParam("freeWord") String word) {
		List<Product> products = productRepository.findName(word);
		model.addAttribute("products", products);
		return "index";
	}

}

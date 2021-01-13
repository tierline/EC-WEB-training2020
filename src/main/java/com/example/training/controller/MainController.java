package com.example.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.training.domain.Product;
import com.example.training.repository.ProductRepository;

@RestController
public class MainController {
	@Autowired
	private ProductRepository productRepository;

	@CrossOrigin
	@GetMapping("/api/all")
	public List<Product> index() {
		var products = productRepository.findAll();
		return products;
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

package com.example.training.common.controller;

import com.example.training.common.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	/**
	 * 商品詳細画面に遷移
	 */
	@GetMapping("detail/{productId}")
	public String detail(@PathVariable int productId, Model model) {
		var product = productRepository.findId(productId).orElseThrow(() -> new IllegalArgumentException());
		model.addAttribute("product", product);
		return "product/detail";
	}
}
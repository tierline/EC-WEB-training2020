package com.example.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.training.domain.Product;
import com.example.training.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	/**
	 * 商品詳細画面に遷移
	 */
	@GetMapping("detail/{id}")
	public Product detail(@PathVariable("id") int id) {
		var product = productRepository.findId(id).orElseThrow(() -> new IllegalArgumentException());
		return product;
	}
}

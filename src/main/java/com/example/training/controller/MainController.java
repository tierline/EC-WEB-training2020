package com.example.training.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import com.example.training.common.repository.ProductRepository;
import com.example.training.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	protected HttpSession session;

	@Autowired
	protected MessageSource messageSource;

	@GetMapping("/")
	public String index(Model model) {
		List<Product> products = productRepository.findAll();
		model.addAttribute("products", products);
		return "index";
	}

	/**
	 * フリーワード検索
	 *
	 * @param model
	 * @param word
	 * @return
	 */
	@PostMapping("/search")
	public String search(Model model, @RequestParam("freeWord") String freeWord) {
		List<Product> products = productRepository.findName(freeWord);
		model.addAttribute("freeWord", freeWord);
		model.addAttribute("products", products);
		if (products.size() == 0) {
			model.addAttribute("errorMessage", messageSource.getMessage("error.search.noProduct", null, Locale.JAPAN));
		}
		return "search";
	}

}

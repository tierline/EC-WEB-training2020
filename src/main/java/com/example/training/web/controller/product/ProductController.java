package com.example.training.web.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.training.common.entity.ProductEntity;
import com.example.training.common.repository.ProductRepository;

/**
 * 商品のコントローラ
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	/**
	 * 商品詳細画面を表示する。
	 *
	 * @param productId
	 * @param model
	 * @return 商品詳細画面
	 */
	@GetMapping("detail/{productId}")
	public String detail(@PathVariable int productId, Model model) {
		ProductEntity product = productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException());
		model.addAttribute("product", product);
		return "product/detail";
	}
}

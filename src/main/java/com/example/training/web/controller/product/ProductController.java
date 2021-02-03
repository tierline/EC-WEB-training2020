package com.example.training.web.controller.product;

import com.example.training.common.domain.value.id.ProductId;
import com.example.training.common.entity.ProductEntity;
import com.example.training.common.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@GetMapping("detail/{id}")
	public String detail(@PathVariable Long id, Model model) {
		ProductId productId = new ProductId(id);
		ProductEntity product = productRepository.findById(productId).orElseThrow(IllegalArgumentException::new);
		model.addAttribute("product", product);
		return "product/detail";
	}
}

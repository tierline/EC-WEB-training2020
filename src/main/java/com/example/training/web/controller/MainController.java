package com.example.training.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import com.example.training.common.controller.ProductDTO;
import com.example.training.common.domain.Product;
import com.example.training.common.entity.ProductEntity;
import com.example.training.common.repository.ProductRepository;

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

	/**
	 * トップ画面を表示する。
	 *
	 * @param model
	 * @return
	 */

	@GetMapping("/")
	public String index(Model model) {
		List<ProductEntity> productEntities = productRepository.findAll();
		List<ProductDTO> productsDTO = new ArrayList<ProductDTO>();
		for (ProductEntity productEntity : productEntities) {
			productsDTO.add(new ProductDTO(productEntity));
		}
		model.addAttribute("products", productsDTO);
		return "index";
	}

	/**
	 * フリーワード検索
	 *
	 * @param model
	 * @param word
	 * @return
	 */
	// TODO: 問い合わせはQuery, Mobileのフォームは Command
	// 更新系：command : DBにINSERT, DELETE等をかける場合
	// 登録系：query : DBにSELECTをかける場合
	// 検索は SELECT をかける登録系なので Query。freeword -> query
	@PostMapping("/search")
	public String search(Model model, @RequestParam("freeWord") String freeWord) {
		List<ProductEntity> productEntities = productRepository.findName(freeWord);
		List<Product> products = new ArrayList<Product>();
		for (ProductEntity productEntity : productEntities) {
			products.add(new Product(productEntity));
		}
		model.addAttribute("freeWord", freeWord);
		model.addAttribute("products", products);
		if (products.size() == 0) {
			model.addAttribute("errorMessage", messageSource.getMessage("error.search.noProduct", null, Locale.JAPAN));
		}
		return "search";
	}

}

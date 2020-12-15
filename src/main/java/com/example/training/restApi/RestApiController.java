package com.example.training.restApi;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.training.common.domain.Product;
import com.example.training.common.repository.ProductRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RestApiController {

	private ProductRepository productRepository;

	@GetMapping("/common/products")
	public List<Product> product() {
		List<Product> items = productRepository.findAll();
		return items;
	}

}

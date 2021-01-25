package com.example.training.api;

import java.util.ArrayList;
import java.util.List;

import com.example.training.common.domain.Product;
import com.example.training.common.domain.ProductEntity;
import com.example.training.common.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RestApiController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/product")
	public List<Product> product() {
		List<ProductEntity> productEntities = productRepository.findAll();
		List<Product> products = new ArrayList<Product>();
		for (ProductEntity productEntity : productEntities) {
			products.add(new Product(productEntity));
		}

		return products;
	}

}

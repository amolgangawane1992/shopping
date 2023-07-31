package com.inventory.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.shopping.model.Product;
import com.inventory.shopping.repository.ProductRepo;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepo productRepo ;
	
	@GetMapping("/")
	public List<Product> getAllProduct(){
		
		return productRepo.findAll();
	}
	
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product) {
		
		return productRepo.save(product);
	}
	
}

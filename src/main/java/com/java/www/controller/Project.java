package com.java.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.www.model.Product;
import com.java.www.repository.ProductRepository;
@RestController
public class ProductController {
	
	@Autowired
	ProductRepository repository;
	
	@PostMapping("/product")
	  public String createProduct(@RequestBody Product product) {
		repository.save(product);
		  return "product data is stored in database";
	}
	
	@GetMapping("/students")
	 public String getProducts() {
		return "Khit prods";
    }
	@GetMapping("/product/{id}")
	public List<Product> getProds(){
		return repository.findAll();
	}
	@PutMapping("/product/{id}")
	public String updateProduct(
			@PathVariable int id,
			@RequestBody Product product) {
		product.setId(id);
		repository.save(product);
		return "product data is updated";
	}
	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable int id) {
		repository.deleteById(id);
		 return "product is deleted";
	}
}


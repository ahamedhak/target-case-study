package com.targert.ProductDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.targert.ProductDemo.model.Product;
import com.targert.ProductDemo.service.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") long id){
		Product product = service.getProduct(id);
		if(product == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
		
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<Product> updateByPut(@PathVariable("id") long id,@RequestBody Product product){
		product.setId(id);
		Product newProduct = service.updateProduct(product);
		if(newProduct == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Product>(newProduct, HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateByPost(@PathVariable("id") long id,@RequestBody Product product){
		product.setId(id);
		Product newProduct = service.updateProduct(product);
		if(newProduct == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Product>(newProduct, HttpStatus.OK);
		
	}
	

}

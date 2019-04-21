package com.target.PriceDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.target.PriceDemo.model.Price;
import com.target.PriceDemo.service.PriceService;

@RestController
@RequestMapping(value = "/price")
public class PriceController {

	@Autowired
	PriceService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Price> getPriceById(@PathVariable("id") long id) {
		return new ResponseEntity<Price>(service.getById(id), HttpStatus.OK);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Price> updatePrice(@PathVariable("id") long id, @RequestBody Price price) {
		price.setId(id);
		return new ResponseEntity<Price>(service.update(price), HttpStatus.OK);
	}

}

package com.targert.ProductDemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Product {

	private long id;
	
	private String name;
	
	@JsonProperty("current_price")
	private Price currentPrice;

}

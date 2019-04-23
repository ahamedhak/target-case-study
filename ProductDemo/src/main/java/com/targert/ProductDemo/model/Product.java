package com.targert.ProductDemo.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
	@Valid
	@NotNull
	private Price currentPrice;

}

package com.targert.ProductDemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Price {

	private Float value;
	
	@JsonProperty("currency_code")
	private String currencyCode;
	

}
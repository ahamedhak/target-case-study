package com.targert.ProductDemo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Price {

	@Positive
	private Float value;
	
	@JsonProperty("currency_code")
	@NotBlank
	private String currencyCode;
	

}
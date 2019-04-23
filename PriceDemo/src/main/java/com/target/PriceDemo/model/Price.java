package com.target.PriceDemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "product_price")
public class Price {
	
	@Id
	private long id;
	
	@Column(name = "value")
	@NotNull
	private Float value;
	
	@Column(name = "currency_code")
	@JsonProperty(value = "currency_code")
	@NotBlank(message = "currency_code cannot be blank/null")
	private String currencyCode;
	

}

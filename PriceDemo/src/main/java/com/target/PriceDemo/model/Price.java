package com.target.PriceDemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private Float value;
	
	@Column(name = "currency_code")
	@JsonProperty(value = "currency_code")
	private String currencyCode;
	

}

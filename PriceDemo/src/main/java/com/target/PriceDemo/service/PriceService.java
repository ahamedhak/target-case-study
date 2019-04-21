package com.target.PriceDemo.service;

import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.target.PriceDemo.dao.PriceDao;
import com.target.PriceDemo.model.CurrencyCode;
import com.target.PriceDemo.model.Price;

@Service
@Transactional
public class PriceService {
	
	private static final Random RANDOM = new Random();
	
	@Autowired
	PriceDao dao;
	
	public Price create(Price price) {
		return dao.create(price);
	}
	
	public Price update(Price price) {
		 try {
			dao.update(price);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			dao.create(price);
		}
		 return price;
	}
	
	public Price getById(long id) {
		Price price = dao.getById(id);
		if(price == null) {
			price = new Price();
			price.setId(id);
			price.setCurrencyCode(CurrencyCode.randomCode().toString());
			price.setValue(RANDOM.nextFloat()*100);
			dao.create(price);
		}
		return price;
	}


}

package com.target.PriceDemo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.target.PriceDemo.model.Price;

@Repository
public class PriceDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Price create(Price price) {
		entityManager.persist(price);
		return price;
	}
	
	public Price update(Price price) {
		return entityManager.merge(price);
	}
	
	public Price getById(long id) {
		return entityManager.find(Price.class, id);
	}

}

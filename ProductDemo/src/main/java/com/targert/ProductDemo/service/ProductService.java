package com.targert.ProductDemo.service;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.targert.ProductDemo.model.Price;
import com.targert.ProductDemo.model.Product;

@Service
public class ProductService {

	String productNameURL = "https://redsky.target.com/v2/pdp/tcin/{product_id}?excludes=taxonomy,price,promotion,bulk _ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";

	String productPriceURL = "http://localhost:8888/price/{id}";
	
	@Autowired
	RestTemplate restTemplate;

	public Product getProduct(long id) {
		Product product = new Product();
		String productName = getProductName(id);
		if (productName == null)
			return null;
		else {
			product.setId(id);
			product.setName(productName);
			product.setCurrentPrice(getProductPrice(id));
			return product;
		}

	}

	private String getProductName(Long id) {
		Map<String, Object> params = new HashMap<>();
		params.put("product_id", id);
		try {
			String result = restTemplate.getForObject(productNameURL, String.class, params);
			JSONObject product = new JSONObject(result);
			return product.getJSONObject("product").getJSONObject("item").getJSONObject("product_description")
					.getString("title");
		} catch (Exception e) {
			return null;
		}
	}
	
	public Product updateProduct(Product product) {
		String productName = getProductName(product.getId());
		if (productName == null)
			return null;
		else {
			updateProductPrice(product.getId(), product.getCurrentPrice());
			return product;
		}
	}

	private Price getProductPrice(long id) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		Price price = restTemplate.getForObject(productPriceURL, Price.class, params);
		return price;
	}

	private Price updateProductPrice(long id, Price price) {
		HttpEntity<Price> requestEntity = new HttpEntity<Price>(price);
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		HttpEntity<Price> response = restTemplate.exchange(productPriceURL, HttpMethod.PUT, requestEntity, Price.class,
				params);
		return response.getBody();
	}

	

}

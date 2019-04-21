package com.target.PriceDemo.model;

import java.util.Random;


	
	public enum CurrencyCode {
		  USD,
		  INR,
		  EUR;
		  //...

		  private static final CurrencyCode[] VALUES = values();
		  private static final int SIZE = VALUES.length;
		  private static final Random RANDOM = new Random();

		  public static CurrencyCode randomCode()  {
		    return VALUES[RANDOM.nextInt(SIZE)];
		  }
		}



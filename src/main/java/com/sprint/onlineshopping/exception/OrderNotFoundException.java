package com.sprint.onlineshopping.exception;

public class OrderNotFoundException extends RuntimeException{

	public OrderNotFoundException(String msg) {
		
		super(msg);
	}
}

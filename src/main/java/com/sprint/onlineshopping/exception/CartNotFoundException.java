package com.sprint.onlineshopping.exception;

public class CartNotFoundException extends RuntimeException {

	public CartNotFoundException(String msg) {
		
		super(msg);
	}
}

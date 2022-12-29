package com.sprint.onlineshopping.dto;

import java.util.ArrayList;
import java.util.List;

public class CartDto {

	private int cartId;	
	private double cartTotal;	
	private int count;
	private List<CartItemDto> cartItems = new ArrayList<>();
	
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public double getCartTotal() {
		return cartTotal;
	}
	public void setCartTotal(double cartTotal) {
		this.cartTotal = cartTotal;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<CartItemDto> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItemDto> cartItems) {
		this.cartItems = cartItems;
	}	
}

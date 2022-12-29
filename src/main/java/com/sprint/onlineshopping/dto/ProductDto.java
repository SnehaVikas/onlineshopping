package com.sprint.onlineshopping.dto;

import javax.validation.constraints.NotNull;

public class ProductDto {
	
	@NotNull(message = "product id is required")
	private int productId;
	
	@NotNull(message = "product name is required")
	private String productName;
	
	@NotNull(message = " product price is required")
	private double productPrice;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}	
}


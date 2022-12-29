package com.sprint.onlineshopping.dto;

import javax.validation.constraints.NotNull;

public class CustomerDto {

	private long userId;

	@NotNull(message = "user Name is required")
	private String username;

	@NotNull(message = "password is required")
	private String password;

	@NotNull(message = "role is required")
	private String role;

	@NotNull(message = "Customer Name is required")
	private String customerName;

	@NotNull(message = "mobile is required")
	private String mobile;

	@NotNull(message = "email is required")
	private String email;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

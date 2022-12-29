package com.sprint.onlineshopping.service;

import java.util.List;

import com.sprint.onlineshopping.dto.CartDto;
import com.sprint.onlineshopping.dto.CustomerDto;
import com.sprint.onlineshopping.entity.Customer;



public interface CustomerService {

	public CustomerDto saveCustomer(CustomerDto customerDto); 
	public CustomerDto getCustomerById(long customerId); 
	public List<Customer> getAllCustomers(); 
	
	public CartDto getCartByCustomer(long customerId);
}

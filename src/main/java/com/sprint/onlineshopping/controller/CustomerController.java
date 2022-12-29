package com.sprint.onlineshopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.onlineshopping.dto.CartDto;
import com.sprint.onlineshopping.dto.CustomerDto;
import com.sprint.onlineshopping.entity.Customer;
import com.sprint.onlineshopping.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/all")
	public List<Customer> fetchAllCustomers() {
		List<Customer> list = customerService.getAllCustomers();
		return list;
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDto> fetchCustomerDetails(@PathVariable("customerId") int customerId) {
		CustomerDto customer = customerService.getCustomerById(customerId);
		ResponseEntity<CustomerDto> responseEntity = new ResponseEntity<>(customer, HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping("/save")
	public ResponseEntity<CustomerDto> addCustomer(@Valid @RequestBody CustomerDto customer) {
		CustomerDto newCustomer = customerService.saveCustomer(customer);
		ResponseEntity<CustomerDto> responseEntity = new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/{customerId}/cart")
	public ResponseEntity<CartDto> fetchCustomerCart(@PathVariable("customerId") int customerId) {
		CartDto cartDto = customerService.getCartByCustomer(customerId);
		ResponseEntity<CartDto> responseEntity = new ResponseEntity<>(cartDto, HttpStatus.OK);
		return responseEntity;
	}
}

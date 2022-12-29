package com.sprint.onlineshopping.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint.onlineshopping.dto.CartDto;
import com.sprint.onlineshopping.entity.Cart;
import com.sprint.onlineshopping.entity.Customer;
import com.sprint.onlineshopping.exception.CartNotFoundException;
import com.sprint.onlineshopping.exception.CustomerNotFoundException;
import com.sprint.onlineshopping.repository.CartRepository;
import com.sprint.onlineshopping.repository.CustomerRepository;

@SpringBootTest
public class CustomerServiceTest {
	
	@InjectMocks
	private CustomerServiceImpl customerService = new CustomerServiceImpl();
	
	@Mock
	private CustomerRepository customerRepository;

	
	@Test
	public void testGetCustomerByIdException() {
		
		when(customerRepository.findById((long) 1)).thenThrow(CustomerNotFoundException.class);
		
		assertThrows(CustomerNotFoundException.class,()->customerService.getCustomerById(1));
	}
	
	@Test
	void testGetAllCustomers() {
		
		List<Customer> customers = new ArrayList<Customer>();
		
		Customer customer1 = new Customer();

		customer1.setUserId(1);
		customer1.setCustomerName("mayu");
		customer1.setEmail("mayu@gmail.com");
		customer1.setMobile("7845902334");
		customer1.setUsername("mayuri");
		customer1.setPassword("m@123");
		
		
		Customer customer2 = new Customer();
		
		customer2.setUserId(2);
		customer2.setCustomerName("sneha");
		customer2.setEmail("s@gmail.com");
		customer2.setMobile("8845672334");
		customer2.setUsername("sneha");
		customer2.setPassword("s@123");
		
		
 		customers.add(customer1);
 		customers.add(customer2);
		
		
		
		when(customerRepository.findAll()).thenReturn(customers);
		
		List<Customer> customerList = customerService.getAllCustomers();
		
		assertEquals(2,customerList.size());				
	}
}
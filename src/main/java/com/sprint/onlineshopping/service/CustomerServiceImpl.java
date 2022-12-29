package com.sprint.onlineshopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.onlineshopping.dto.CartDto;
import com.sprint.onlineshopping.dto.CartItemDto;
import com.sprint.onlineshopping.dto.CustomerDto;
import com.sprint.onlineshopping.dto.ProductDto;
import com.sprint.onlineshopping.entity.Cart;
import com.sprint.onlineshopping.entity.CartItem;
import com.sprint.onlineshopping.entity.Customer;
import com.sprint.onlineshopping.entity.Product;
import com.sprint.onlineshopping.exception.ResourceNotFoundException;
import com.sprint.onlineshopping.repository.CartRepository;
import com.sprint.onlineshopping.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public CustomerDto saveCustomer(CustomerDto customerDto) {
		
		Customer customer = new Customer();
		customer.setCustomerName(customerDto.getCustomerName());
		customer.setEmail(customerDto.getEmail());
		customer.setMobile(customerDto.getMobile());
		customer.setUsername(customerDto.getUsername());
		customer.setPassword(customerDto.getPassword());
		customer.setRole("customer");
				
		Cart cart = new Cart();
		cart.setCartTotal(0);
		cart.setCount(0);		
		
		cartRepository.save(cart);
		
		cart.setCustomer(customer);
		customer.setCart(cart);			
		customerRepository.save(customer);	
		
		customerDto.setUserId(customer.getUserId());
	
		return customerDto;
	}

	@Override
	public CustomerDto getCustomerById(long customerId) {
	
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isEmpty()) {
			throw new ResourceNotFoundException("Customer not existing with id: "+customerId);
		}
		Customer customer = optionalCustomer.get();
		
		CustomerDto customerDto = new CustomerDto();
		customerDto.setUserId(customer.getUserId());
		customerDto.setCustomerName(customer.getCustomerName());
		customerDto.setEmail(customer.getEmail());
		customerDto.setMobile(customer.getMobile());
		customerDto.setUsername(customer.getUsername());
		customerDto.setPassword(customer.getPassword());
		
		return customerDto;
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> customer = customerRepository.findAll();
		return customer;
	}

	@Override
	public CartDto getCartByCustomer(long customerId) {
	
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isEmpty()) {
			throw new ResourceNotFoundException("Customer not existing with id: "+customerId);
		}
		Customer customer = optionalCustomer.get();
		
		Cart cart = customer.getCart();
		
		CartDto cartDto = new CartDto();
		cartDto.setCartId(cart.getCartId());
		cartDto.setCount(cartDto.getCount());
		cartDto.setCartTotal(cart.getCartTotal());
		
		List<CartItem> cartItems = cart.getCartItems();
		
		List<CartItemDto> cartDtoItems = cartDto.getCartItems();
		
		cartItems.forEach(item-> {
			CartItemDto itemDto = new CartItemDto();
			itemDto.setCartItemId(item.getCartItemId());
			itemDto.setQuantity(item.getQuantity());
			itemDto.setItemTotal(item.getItemTotal());
			
			Product product = item.getProduct();
			
			ProductDto productDto = new ProductDto();
			productDto.setProductId(product.getProductId());
			productDto.setProductName(product.getProductName());
			productDto.setProductPrice(product.getProductPrice());			
			
			itemDto.setProductDto(productDto);
			
			cartDtoItems.add(itemDto);
			
		});
		
		return cartDto;
	}

}

package com.sprint.onlineshopping.service;

import java.util.List;

import com.sprint.onlineshopping.dto.CartDto;
import com.sprint.onlineshopping.entity.Cart;
import com.sprint.onlineshopping.exception.CartNotFoundException;

public interface CartService {

	CartDto addItem(int cartId, int productId, int quantity);

	List<CartDto> getAllCartProduct();

	CartDto getCartItemById(int cartId) throws CartNotFoundException;

	

	

}

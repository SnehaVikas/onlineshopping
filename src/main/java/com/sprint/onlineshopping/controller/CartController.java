package com.sprint.onlineshopping.controller;


import java.util.List;



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
import com.sprint.onlineshopping.dto.CartItemReq;
import com.sprint.onlineshopping.exception.CartNotFoundException;
import com.sprint.onlineshopping.service.CartService;



@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;

	@PostMapping("/additem")
	public ResponseEntity<CartDto> addItemToCart(@RequestBody CartItemReq cartItemReq) {
		CartDto newCart = cartService.addItem(cartItemReq.getCartId(), cartItemReq.getProductId(), cartItemReq.getQuantity());
		ResponseEntity<CartDto> responseEntity = new ResponseEntity<>(newCart, HttpStatus.OK);
		return responseEntity;
	}
	
	
	@GetMapping("/cart/{id}")
    public ResponseEntity<CartDto> fetchCartDetails(@PathVariable("id") int cartId) throws CartNotFoundException {
        CartDto cart=cartService.getCartItemById(cartId);
        ResponseEntity<CartDto> responseEntity=null;
        if(cart!=null) {
            responseEntity=new ResponseEntity<>(cart,HttpStatus.OK);
        }
        else {
            responseEntity=new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
    
   

    @GetMapping("/cart/all")
    public List<CartDto> fetchAllCart(){
        List<CartDto> list=cartService.getAllCartProduct();
        return list;
    }
    
    
}

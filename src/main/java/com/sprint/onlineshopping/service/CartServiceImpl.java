package com.sprint.onlineshopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.onlineshopping.dto.CartDto;
import com.sprint.onlineshopping.dto.CartItemDto;
import com.sprint.onlineshopping.dto.ProductDto;
import com.sprint.onlineshopping.entity.Cart;
import com.sprint.onlineshopping.entity.CartItem;
import com.sprint.onlineshopping.entity.Product;
import com.sprint.onlineshopping.exception.CartNotFoundException;
import com.sprint.onlineshopping.exception.ResourceNotFoundException;
import com.sprint.onlineshopping.repository.CartItemRepository;
import com.sprint.onlineshopping.repository.CartRepository;
import com.sprint.onlineshopping.repository.ProductRepository;



@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public CartDto addItem(int cartId,int productId, int quantity) {
		
		Optional<Cart> optionalCart = cartRepository.findById(cartId);
		if(optionalCart.isEmpty()) {
			throw new ResourceNotFoundException("Cart not existing with id: "+cartId);
		}
		Cart cart = optionalCart.get();
		
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if(optionalProduct.isEmpty()) {
			throw new ResourceNotFoundException("Product not existing with id: "+cartId);
		}
		Product product = optionalProduct.get();
		
		CartItem cartItem = new CartItem();
		cartItem.setQuantity(quantity);
		double itemTotal = quantity*product.getProductPrice();
		cartItem.setItemTotal(itemTotal);
		cartItem.setProduct(product);		
		cartItem.setCart(cart);
		List<CartItem> cartItems = cart.getCartItems();
		cartItems.add(cartItem);
		
		cartItemRepository.save(cartItem);
		
		
		double cartTotal = cart.getCartTotal();
		
		double newCartTotal = cartTotal+itemTotal;
		cart.setCartTotal(newCartTotal);		
		cart.setCount(cartItems.size());
		
		cartRepository.save(cart);
		
		CartDto cartDto = new CartDto();
		cartDto.setCartId(cart.getCartId());
		cartDto.setCount(cart.getCount());
		cartDto.setCartTotal(cart.getCartTotal());
		
		List<CartItemDto> cartDtoItems = cartDto.getCartItems();
		cartItems.forEach(item-> {
			CartItemDto cartItemDto = new CartItemDto();
			cartItemDto.setCartItemId(item.getCartItemId());
			cartItemDto.setItemTotal(item.getItemTotal());
			cartItemDto.setQuantity(item.getQuantity());
			
			ProductDto productDto = new ProductDto();
			productDto.setProductId(item.getProduct().getProductId());
			productDto.setProductName(item.getProduct().getProductName());
			productDto.setProductPrice(item.getProduct().getProductPrice());
			
			cartItemDto.setProductDto(productDto);
			
			cartDtoItems.add(cartItemDto);
		});
		
		return cartDto;
	}
	
	@Override
	public List<CartDto> getAllCartProduct() 
	{	
		
		return null;
	}
	
	@Override
	public CartDto getCartItemById(int cartId) throws CartNotFoundException  
    {
	         Optional<Cart> optionalCart = cartRepository.findById(cartId);
	         if(optionalCart.isEmpty())
	         {
	                    		
	        	 throw new CartNotFoundException("Cart Item not existing with id:"+cartId);
	         }
	         Cart cart = optionalCart.get();
	         
	        CartDto cartDto = new CartDto();
	 		cartDto.setCartId(cart.getCartId());
	 		cartDto.setCount(cart.getCount());
	 		cartDto.setCartTotal(cart.getCartTotal());
	 		
	 		return cartDto;
     }

}

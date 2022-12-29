package com.sprint.onlineshopping.entity;


//// one to one wishlist to product bidirection
////one to many for product to category 
// one to one for product to cartitems unidirection
//one to one for product to orderitems unidirection
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_tbl")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;	
	
	@Column(name = "product_name")
	private String productName;	
	
	@Column(name = "product_price")
	private double productPrice;	
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;	
	
	@ManyToMany(mappedBy = "wishlist")
	private Set<Customer> likes = new HashSet<>();

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
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Customer> getLikes() {
		return likes;
	}

	public void setLikes(Set<Customer> likes) {
		this.likes = likes;
	}	
}

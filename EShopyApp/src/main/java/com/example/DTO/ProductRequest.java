package com.example.DTO;

import jakarta.validation.constraints.NotNull;

public class ProductRequest {
	@NotNull(message="product name should be not null")
	private String pname;
	@NotNull(message="category should be not null")
	private String category;
	@NotNull(message="discription should be not null")
	private String discription;
	@NotNull(message="price should be not null")
	private double price;
	public ProductRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductRequest(@NotNull(message = "product name should be not null") String pname,
			@NotNull(message = "category should be not null") String category,
			@NotNull(message = "discription should be not null") String discription,
			@NotNull(message = "price should be not null") double price) {
		super();
		this.pname = pname;
		this.category = category;
		this.discription = discription;
		this.price = price;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}

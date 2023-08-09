package com.shop.main.stock.classes;

public class Product {
	private String name;
	private float price;
	
	public Product(String name) {
		super();
		this.name = name;
	}
	
	public Product(String name, float price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}	
}
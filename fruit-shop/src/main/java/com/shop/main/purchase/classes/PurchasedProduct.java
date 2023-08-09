package com.shop.main.purchase.classes;

public class PurchasedProduct {
	private String name;
	private int quantity;
	
	public PurchasedProduct(String name, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
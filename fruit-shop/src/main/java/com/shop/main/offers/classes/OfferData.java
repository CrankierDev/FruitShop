package com.shop.main.offers.classes;

import com.shop.main.stock.classes.Product;

public class OfferData extends Product {
	private boolean buyThreePayTwo;
	private float discountEachEuros;
	
	public OfferData(String name, boolean buyThreePayTwo, float discountEachEuros) {
		super(name);
		this.buyThreePayTwo = buyThreePayTwo;
		this.discountEachEuros = discountEachEuros;
	}

	public boolean isBuyThreePayTwo() {
		return buyThreePayTwo;
	}

	public void setBuyThreePayTwo(boolean buyThreePayTwo) {
		this.buyThreePayTwo = buyThreePayTwo;
	}

	public float getDiscountEachEuros() {
		return discountEachEuros;
	}

	public void setDiscountEachEuros(float discountEachEuros) {
		this.discountEachEuros = discountEachEuros;
	}
}
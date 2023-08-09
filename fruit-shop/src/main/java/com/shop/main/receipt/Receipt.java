package com.shop.main.receipt;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Map;

import com.shop.main.offers.classes.OfferData;
import com.shop.main.purchase.classes.PurchasedProduct;
import com.shop.main.stock.classes.Product;

public class Receipt {
	  
	public static void printReceipt (
				HashMap<String, Product> stockList,
				HashMap<String, PurchasedProduct> purchaseList,
				HashMap<String, OfferData> offersList
			) {

		float totalPrice = 0;
		float totalDiscount = 0;
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator('.');
		DecimalFormat df = new DecimalFormat("0.00", symbols);
		
		System.out.println("------------------- RECEIPT -------------------");

		for(Map.Entry<String, PurchasedProduct> set: purchaseList.entrySet()) {
			String productName = set.getKey();
			float partialPrice = purchaseList.get(productName).getQuantity() * stockList.get(productName).getPrice();
			
			System.out.println(df.format(partialPrice) + "€ (" + stockList.get(productName).getPrice()+ "€/each) \t - " +
								purchaseList.get(productName).getQuantity() + " x " + productName);
			
			totalPrice += partialPrice;
		}

		System.out.println("\nTOTAL: " + totalPrice + "€");
		System.out.println("\n------------------ DISCOUNTS ------------------");

		for(Map.Entry<String, PurchasedProduct> set: purchaseList.entrySet()) {
			String productName = set.getKey();
			
			if( offersList.get(productName).isBuyThreePayTwo() ) {
				float partialDiscount = stockList.get(productName).getPrice() * apply3By2(purchaseList.get(productName).getQuantity());
				System.out.println("Buy 3 pay 2 applied on " + productName + " " + df.format(partialDiscount) + "€ off.");
				totalDiscount += partialDiscount;
			}
			
			if( offersList.get(productName).getDiscountEachEuros() != 0 ) {
				float partialPrice = stockList.get(productName).getPrice() * purchaseList.get(productName).getQuantity();
				float partialDiscount = applyDiscountEachEuros(
						offersList.get(productName).getDiscountEachEuros(),
						partialPrice
						);
				
				System.out.println("Discount for spending applied:");
				System.out.println("\t" + df.format(partialDiscount) + "€ off for spending " +
						df.format(partialPrice) + "€ on " + productName + ".");
				totalDiscount += partialDiscount;
			}		
			
		}

		System.out.println("\nTOTAL DISCOUNTS: " + totalDiscount + "€");
		float totalInvoice = totalPrice - totalDiscount;
		System.out.println("\n------------ TOTAL PRICE: " + totalInvoice + "€ ---------------");
	}
	

	public static int apply3By2(int quantity) {
		int reduction = quantity/3;
		
		return reduction;
	}
	
	public static float applyDiscountEachEuros(float eachEuros, float spendOfMoney) {
		int discount = (int) (spendOfMoney / eachEuros);
		
		return discount;
	}
}
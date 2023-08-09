package com.shop.main;

import java.util.HashMap;
import java.util.Properties;

import com.shop.main.offers.Offers;
import com.shop.main.offers.classes.OfferData;
import com.shop.main.properties.PropertiesInitializer;
import com.shop.main.purchase.PurchaseReader;
import com.shop.main.purchase.classes.PurchasedProduct;
import com.shop.main.receipt.Receipt;
import com.shop.main.stock.StockReader;
import com.shop.main.stock.classes.Product;

public class Main {
	private static Properties props = new Properties();
	private static final StockReader stockReader= new StockReader();
	private static final PurchaseReader purchaseReader= new PurchaseReader();
	private static final Offers offers = new Offers();
	
	public static void main(String[] args) {
		props = PropertiesInitializer.loadProperties();

		final String stockFile = props.getProperty("stockFile");
		final HashMap<String, Product> stockList = stockReader.getStockFromFile(stockFile);
		
		final String purchaseFile = props.getProperty("purchaseFile");
		final HashMap<String, PurchasedProduct> purchaseList =
				purchaseReader.getPurchaseFromFile(purchaseFile);

		final String offersFile = props.getProperty("offersFile");
		final HashMap<String, OfferData> offersList = offers.readOffers(offersFile);
		
		Receipt.printReceipt(stockList, purchaseList, offersList);
	}	
}
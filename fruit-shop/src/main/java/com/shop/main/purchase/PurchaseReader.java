package com.shop.main.purchase;

import java.util.HashMap;
import java.util.List;

import com.shop.main.purchase.classes.PurchasedProduct;
import com.shop.main.utils.FileUtils;

public class PurchaseReader {
	public HashMap<String, PurchasedProduct> getPurchaseFromFile(String purchaseCSV) {
		HashMap<String, PurchasedProduct> stockList = new HashMap<String, PurchasedProduct>();
		
		try {
			List<String[]> data = FileUtils.getDataFromCSV(purchaseCSV);
			for( int i = 0; i < data.size(); i++ ) {
				stockList.put( data.get(i)[0],
						new PurchasedProduct(
								data.get(i)[0], 
								Integer.valueOf(data.get(i)[1])
							)
						);
			}		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return stockList;
	}
}
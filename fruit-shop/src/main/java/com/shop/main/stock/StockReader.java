package com.shop.main.stock;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;

import com.shop.main.stock.classes.Product;
import com.shop.main.utils.FileUtils;

public class StockReader {
	public HashMap<String, Product> getStockFromFile(String stockCSV) {
		HashMap<String, Product> stockList = new HashMap<String, Product>();
		
		try {
			List<String[]> data = FileUtils.getDataFromCSV(stockCSV);
			for( int i = 0; i < data.size(); i++ ) {
				stockList.put( data.get(i)[0],
						new Product(
								data.get(i)[0], 
								Float.valueOf(data.get(i)[1])
							)
						);
			}		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return stockList;
	}
}
package com.shop.main.offers;

import java.util.HashMap;
import java.util.List;

import com.shop.main.offers.classes.OfferData;
import com.shop.main.utils.FileUtils;

public class Offers {

	public static HashMap<String, OfferData> readOffers(String offersCSV) {
		HashMap<String, OfferData> offersList = new HashMap<String, OfferData>();
		
		try {
			List<String[]> data = FileUtils.getDataFromCSV(offersCSV);
			for( int i = 0; i < data.size(); i++ ) {
				boolean buyThreePayTwo = data.get(i)[1].equals("Y") ? true : false;

				offersList.put( data.get(i)[0],
						new OfferData(
								data.get(i)[0], 
								buyThreePayTwo,
								Float.valueOf(data.get(i)[2]))
						);
			}		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return offersList;
	}
}

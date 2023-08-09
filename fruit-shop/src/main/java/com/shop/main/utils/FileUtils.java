package com.shop.main.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
	public static List<String[]> getDataFromCSV(String csvFile) {
		List<String[]> dataList = new ArrayList<String[]>();
		
		try {
			BufferedReader br = new BufferedReader( new FileReader(csvFile) );
		    String line;
		    br.readLine();
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        dataList.add( values );
		    }
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dataList;
	}
}

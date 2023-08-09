package com.shop.main.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesInitializer {
	private static InputStream inputProps = null;

	public static Properties loadProperties() {
		Properties props = new Properties();
		
		try {
			inputProps = new FileInputStream("src/main/resources/properties/config.properties");
			props.load(inputProps);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (inputProps != null) {
	            try {
	                inputProps.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
			}
		}
		
		return props;
	}
}
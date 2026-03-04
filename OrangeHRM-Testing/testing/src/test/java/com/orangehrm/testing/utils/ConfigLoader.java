package com.orangehrm.testing.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
	private static final Properties properties = new Properties();
	static {
		String filename = "/config.properties"; 
		try (InputStream inputStream = ConfigLoader.class.getResourceAsStream(filename)) {
			if (inputStream == null) {
				System.err.println("Sorry, unable to find " + filename);
			} else {
				properties.load(inputStream);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key, "NULL"); 
	}
}

package com.ekapiww.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    Properties properties = new Properties();
    InputStream inputStream = null;

    public PropertyReader(String filepath) {
        loadProperties(filepath);
    }

    private void loadProperties(String filepath) {
        try {
            properties.load(PropertyReader.class.getResourceAsStream(filepath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readProperty(String key) {
        return properties.getProperty(key);
    }
	
}

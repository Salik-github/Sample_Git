package com.frameworks.helpers;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesHelpers {

    private static final Map<String, Properties> propertiesCahe = new HashMap<>();
    private static String loadFilePath = "/src/test/java/com/resources/config/";

    public static String getValues(String fileName, String key) {
        Properties properties = loadProperties(fileName);
        if (properties != null) {
            String keyValue = properties.getProperty(key);
            return keyValue != null ? keyValue : "Key not found " + key;
        }
        return "propeties file not found" + fileName;

    }

    public static Properties loadProperties(String fileName) {
        if (propertiesCahe.containsKey(fileName)) {
            return propertiesCahe.get(fileName);
        }
        String filePath = SystemHelper.getCurrentDir() + loadFilePath + fileName;
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties;
        } catch (Exception e) {
            System.out.println("Error Loading" + e.getMessage());
            return null;
        }
    }
}

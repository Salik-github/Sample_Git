package com.example;

import java.io.FileInputStream;
import java.util.Properties;

import com.example.filepath.filespath;


public class getproperty {
    
    public static String GetDataFromPropertyFile(String key)
    {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(filespath.PROPERTY_FILE));
        } catch (Exception e) {
          
            System.out.println(e + "Exception throw from property file");
        } 
        return properties.getProperty(key);
    }
}

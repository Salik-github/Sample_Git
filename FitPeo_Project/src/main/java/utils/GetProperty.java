package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class GetProperty {
    public static String GetDataFromPropertiesFile(String key) {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(FilePath.PropertiesFile));

        } catch (Exception e) {
            System.out.println(e + "This Exception throw from property file");
        }
        return properties.getProperty(key);
    }


    public static String[] GetArrayDataFromPropertiesFile(String key) {
        Properties properties = new Properties();

        String[] array = null;
        try {
            properties.load(new FileInputStream(FilePath.PropertiesFile));
            String arrayData = properties.getProperty(key);

            // Split the string into an array
            array = arrayData.split(",");

        } catch (Exception e) {
            System.out.println(e + "This Exception throw from property file");
        }
        return array;
    }
}

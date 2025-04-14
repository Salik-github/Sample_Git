package com.frameworks.constants;

import com.frameworks.helpers.PropertiesHelpers;

public class FrameworkConstants {
    public static String JSON_PATH = "src/test/java/com/resources/config/userData.json";
    public static final String REPORT_LOCATION ="src/test/java/com/frameworks/Reports/Report_One.xlxs";
    public static final String CONFIG_PROPERTIES_FILE ="config.properties";
    public static final String BROWSER = PropertiesHelpers.getValues(CONFIG_PROPERTIES_FILE, "BROWSER_TYPE");
    public static final String WAIT  = PropertiesHelpers.getValues(CONFIG_PROPERTIES_FILE,"WAIT");
    public static final String SIGNUPURL = PropertiesHelpers.getValues(CONFIG_PROPERTIES_FILE, "SIGNUPURL");
    public static final String JSON_LOCATION = JSON_PATH;
}

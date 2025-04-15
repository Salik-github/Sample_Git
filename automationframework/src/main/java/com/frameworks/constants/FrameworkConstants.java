package com.frameworks.constants;

import com.frameworks.helpers.PropertiesHelpers;

public class FrameworkConstants {

    public static String FORGOT_PASSWORD_URL = "https://rise.anhtester.com/signin/request_reset_password";

    public static String JSON_PATH = "src/test/java/com/resources/config/userData.json";
    public static final String REPORT_LOCATION ="src/test/java/com/frameworks/Reports/Report_One.xlxs";
    public static final String CONFIG_PROPERTIES_FILE ="config.properties";
    public static final String BROWSER = PropertiesHelpers.getValues(CONFIG_PROPERTIES_FILE, "BROWSER_TYPE");
    public static final String WAIT  = PropertiesHelpers.getValues(CONFIG_PROPERTIES_FILE,"WAIT");
    public static final String SIGNUPURL = PropertiesHelpers.getValues(CONFIG_PROPERTIES_FILE, "SIGNUPURL");
    public static final String JSON_LOCATION = JSON_PATH;
    public static String INVALID_EMAIL = PropertiesHelpers.getValues(CONFIG_PROPERTIES_FILE,"INVALIDEMAIL");
    public static String INVALID_PASSWORD = PropertiesHelpers.getValues(CONFIG_PROPERTIES_FILE,"INVALIDPASSWORD");
    public static String DASHBOARD_URL = "https://rise.anhtester.com/dashboard/index/1";



}

package com.frameworks.helpers;

public class SystemHelper {
    
    
    public static String getCurrentDir()
    {
        return System.getProperty("user.dir");
    }
    public static String getUserHomeDir()
    {
        return System.getProperty("user.home");
    }
    public static String getOSname()
    {
        return System.getProperty("os.name");
    }
    public static String getJavaVersion()
    {
        return System.getProperty("java.version");
    }
    public static long getCurrentTimeMillies()
    {
        return System.currentTimeMillis();
    }
}


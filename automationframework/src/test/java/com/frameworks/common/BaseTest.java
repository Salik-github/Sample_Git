package com.frameworks.common;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.frameworks.drivers.DriverManager;


public class BaseTest {
    

    @Parameters("appURL")
    @BeforeMethod
    public void createDriver(String appUrl)
    {
      commonMethod.setBroswerType(appUrl);

      
    }
    @AfterMethod
    public void   quitDriver()
    {
      DriverManager.quitDriver();
    }

  


}

package com.project.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

import com.example.browserType;
import com.example.driverManager;
import com.example.getproperty;
import static com.project.utilis.url.HOME_TITLE;
import static com.project.utilis.url.MAIN_URL;



public class basetest {
    
    protected WebDriver driver;
    @BeforeSuite
    public void setBrowser()
    {
        driverManager.setBrowser(browserType.CHROME);
        driver = driverManager.getDriver();
        driver.get(MAIN_URL);
        waitforURL();waitForHomeTitle();
        Assert.assertEquals(driver.getCurrentUrl(),MAIN_URL );
    }
   

    private void waitforURL()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds((Long.parseLong(getproperty.GetDataFromPropertyFile("Duration")))));
        wait.until(ExpectedConditions.urlToBe(MAIN_URL));
    }
    private void waitForHomeTitle()
    {
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds((Long.parseLong(getproperty.GetDataFromPropertyFile("Duration")))));
        wait.until(ExpectedConditions.titleIs(HOME_TITLE));
    }
}

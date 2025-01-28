package com.project.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import com.example.browserType;
import com.example.driverManager;
import com.example.getproperty;
import com.project.utilis.url;

import freemarker.template.utility.Constants;

public class basetest {
    
    protected WebDriver driver;
    @BeforeSuite
    public void setBrowser()
    {
        driverManager.setBrowser(browserType.CHROME);
        driver = driverManager.getDriver();
    }


    private void waitforURL()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(getproperty.GetDataFromPropertyFile("Duration"))));
        wait.until(ExpectedConditions.urlToBe(url.MAIN_URL));
    }
    private void waitForHomeTitle()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(getproperty.GetDataFromPropertyFile("Duration"))));
        wait.until(ExpectedConditions.titleIs(url.HOME_TITLE));
    }
}

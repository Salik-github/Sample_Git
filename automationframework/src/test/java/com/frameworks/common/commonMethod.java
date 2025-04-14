package com.frameworks.common;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.frameworks.constants.FrameworkConstants;
import com.frameworks.drivers.BrowserFactory;
import com.frameworks.drivers.DriverManager;
import com.frameworks.projectCMS.pages.SignupPage;

import static com.frameworks.keywords.WebUI.*;

public class commonMethod {

    public static void setBroswerType(String URL) {
        String browser = FrameworkConstants.BROWSER;
        if (browser == null || browser.isEmpty()) {
            browser = "chrome";
        }
        createInstance(browser,URL);
    }

    public static void createInstance(String browser,String URL) {
        WebDriver driver = BrowserFactory.valueOf(browser.toUpperCase()).createDriver();
        DriverManager.setDriver(driver);
        driver.get(FrameworkConstants.SIGNUPURL+URL);
        driver.manage().window().maximize();
    }
    public void waitfortitleAndURL()
    {
        WebDriverWait driverWait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(DurationStringtoLong(FrameworkConstants.WAIT)));
        driverWait.until(ExpectedConditions.urlToBe(FrameworkConstants.SIGNUPURL));
        driverWait.until(ExpectedConditions.titleIs(SignupPage.SignupTitle));

    }
}

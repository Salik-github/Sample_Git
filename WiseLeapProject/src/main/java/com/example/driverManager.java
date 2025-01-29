package com.example;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class driverManager {
    private static WebDriver driver;
    public static void setBrowser(browserType browserType) {
        switch (browserType) {
            case CHROME -> {
                WebDriverManager.chromedriver().browserVersion("latest").setup();
                driver = new ChromeDriver();
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case EDGE -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            default -> throw new IllegalArgumentException("This broswser is not recommeded");
        }
        setDriver(driver);
    }
    public static void setDriver(WebDriver driverInstDriver) {
        driver = driverInstDriver;
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(Long.parseLong(getproperty.GetDataFromPropertyFile("Duration"))));
        driver.manage().window().maximize();
    }
    public static WebDriver getDriver()
    {
        return driver;
    }
    public static void quitDriver() {
        if (driver != null)
            driver.quit();
    }
}

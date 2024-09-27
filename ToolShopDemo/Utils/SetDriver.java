package ToolShopDemo.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetDriver {
    private WebDriver driver;

    public WebDriver SetDriverforBrowser(String Browser) {
        if (Browser.equalsIgnoreCase("Chrome")) {
           // WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (Browser.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (Browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Browser not Supported" + " " + Browser);
        }
        driver.manage().window().maximize();
        return driver;
    }

    public void QuitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void CloseDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}

package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager {


    public static WebDriver driver;

    //private  static  ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static void setBrowser(BrowserType browserName) {

        driver = switch (browserName) {
            case CHROME -> new ChromeDriver();
            case FIREFOX -> new FirefoxDriver();
            case EDGE -> new EdgeDriver();
            default -> throw new IllegalArgumentException("You Browser Type is not support");

        };
        setDriver(driver);
    }

    public static void setDriver(WebDriver driverInstance) {
        driver = driverInstance;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
    }

    public static WebDriver getDriverInstance() {
        return driver;
    }


    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}

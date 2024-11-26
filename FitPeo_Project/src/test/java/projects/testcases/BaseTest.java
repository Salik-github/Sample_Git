package projects.testcases;

import Data.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import projects.pages.HomePage;
import projects.pages.RevenueCalculatorPage;
import utils.BrowserType;
import utils.DriverManager;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    protected HomePage HomePageObject;
    protected RevenueCalculatorPage RevenuePageObject;

    @BeforeSuite
    public void SetProjectURL() {

        DriverManager.setBrowser(BrowserType.CHROME);
        driver = DriverManager.getDriverInstance();

        // Set URL
        driver.get(Constants.HOMEPAGEURL);
        driver.manage().window().maximize();
        waitForURL(Constants.HOMEPAGEURL);
        waitForHomeTitle();
        expectedAssert(driver.getCurrentUrl(), Constants.HOMEPAGEURL);

    }

    @BeforeTest
    public void ObjectInstance() {
        HomePageObject = new HomePage(driver);
        RevenuePageObject = new RevenueCalculatorPage(driver);
    }

    @AfterSuite
    public void driverClose() {
        DriverManager.quitDriver();
    }

    public void waitForURL(String URL) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.urlToBe(URL));
    }

    public void waitForHomeTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.titleIs(Constants.HOMEPAGETITLE));
    }

    public void expectedAssert(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    public void waitForElementVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}

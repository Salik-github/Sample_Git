package projects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;

    }


    public void clickButton(By element) {
        WebElement button = driver.findElement(element);
        button.click();
    }

    public void expectedAssert(String actual, String expected) {

        Assert.assertEquals(actual, expected);
    }
    public  void waitForURL(String URL)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.urlToBe(URL));
    }


    public void scrollDownToParticularElement(By sliderHeader) {
        WebElement element = driver.findElement(sliderHeader);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);

    }


}


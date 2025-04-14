package com.frameworks.keywords;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.frameworks.constants.FrameworkConstants;
import com.frameworks.drivers.DriverManager;

public class WebUI {

    public static WebElement BytoWebElement_forEnterData(By by) {
        return DriverManager.getDriver().findElement(by);

    }

    public static void enterData(By by, String value) {
        WebElement element = BytoWebElement_forEnterData(by);
        element.sendKeys(value);
    }

    public static void clickMethod(By by) {
        WebElement element = BytoWebElement_forEnterData(by);
        element.click();
    }

    public static void waitElementForvisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),
                Duration.ofSeconds(DurationStringtoLong(FrameworkConstants.WAIT)));
        wait.until(ExpectedConditions.visibilityOf(e));

    }

    public static long DurationStringtoLong(String M) {
        return Long.parseLong(M);
    }

    public static void checkMessageDisplay(By by) {
        waitElementForvisibility1(by);
    }

    public static void waitforElement(By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),
                Duration.ofSeconds(DurationStringtoLong(FrameworkConstants.WAIT)));
        wait.until(ExpectedConditions.visibilityOf(BytoWebElement_forEnterData(by)));
    }

    public static void waitForElementclickable(By by) {
        WebElement element = BytoWebElement_forEnterData(by);
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),
                Duration.ofSeconds(DurationStringtoLong(FrameworkConstants.WAIT)));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void ScroltoElement(By by) {
        WebElement element = BytoWebElement_forEnterData(by);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.scrollToElement(element).perform();
    }

    public static void waitElementForvisibility1(By e) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),
                Duration.ofSeconds(DurationStringtoLong(FrameworkConstants.WAIT)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(e));

    }
    public static void waitForURL(String URL)
    {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),
        Duration.ofSeconds(DurationStringtoLong(FrameworkConstants.WAIT)));
        wait.until(ExpectedConditions.urlContains(URL));
    }

}

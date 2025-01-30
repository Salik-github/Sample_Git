package com.project.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class basepage {

    public WebDriver driver;
    public basepage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickElement(WebElement element)
    {
        element.click();
    }
    public void sendValue(WebElement element , String value)
    {
        element.sendKeys(value);
    }
     public void waitElement(By element)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)) ;
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));

    }
    public void waitElementobeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        clickElement(element);
    }

    public void waitElementobeVisible(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));

    }
}

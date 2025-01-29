package com.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}

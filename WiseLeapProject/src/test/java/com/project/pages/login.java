package com.project.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.example.getproperty;
import static com.project.utilis.url.HOMEPAGE_URL;

public class login extends basepage {
    
    public login(WebDriver driver)
    {
        super(driver);
    }

    private  final By loginButton = By.xpath("//span[@class='v-btn__content']");
    private final  By phoneNumber = By.cssSelector(".vti__input");
    private final  By otpButton =By.xpath("//span[text()=' Get OTP ']");
    private final By countryCode =   By.cssSelector("div[aria-label='Country Code Selector']");
    private final By search =   By.cssSelector("input[aria-label='Search by country name or country code']");
    private final By indiatext =By.xpath("//li[contains(., 'India (भारत)')]");
    private final By otpby = By.xpath("//div[@class='v-text-field__slot']");
    private final By verifyby = By.xpath("//span[text()=' Verify ']");
    private final By visibletext = By.xpath("//div[text()='Testing Institute']");
    public void clickContinueWithMobile(){

        List<WebElement> element = driver.findElements(loginButton);
        clickElement(element.get(2));

       
    }
    public void waitElementobeClickable(WebElement element)
    {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.elementToBeClickable(element));
         clickElement(element);
    }
    public void waitElementobeVisible(By element)
    {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.visibilityOfElementLocated(element));

    }
    public void testLoginWithPhoneNumberAndOTP() 
    {
       
        WebElement countryCodeDropdown = driver.findElement(countryCode);
        waitElementobeClickable(countryCodeDropdown);

        WebElement searchBox = driver.findElement(search);

        waitElementobeVisible( search);
        searchBox.sendKeys("India");

        WebElement indiaOption = driver.findElement(indiatext);
        waitElementobeClickable(indiaOption);


        WebElement ph = driver.findElement(phoneNumber);
        WebElement otp = driver.findElement(otpButton);
    

        sendValue(ph,getproperty.GetDataFromPropertyFile("phoneNumber"));

        clickElement(otp);

        enterotp();

        WebElement verifyButton = driver.findElement(verifyby);
        clickElement(verifyButton); 
        

         WebElement heading = driver.findElement(visibletext);
         waitElement(visibletext);
         Assert.assertTrue(heading.isDisplayed());

         Assert.assertEquals(driver.getCurrentUrl(), HOMEPAGE_URL);


    }

    public void enterotp()
    {
        // List<WebElement> otpField = driver.findElements(otpby);
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // wait.until(ExpectedConditions.elementToBeClickable(otpField.getFirst()));
        String otp ="0000";
        for (int i = 0; i < otp.length(); i++) {
            
            driver.findElement(By.id("input-35--" + i)).sendKeys(String.valueOf(otp.charAt(i)));
        }

    }
    public void waitElement(By element)
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)) ;
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));

    }
}

package website.PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class TestCase10Page extends CommonPageMethod {
    
    public TestCase10Page(WebDriver driver)
    {
        super(driver);
    }

    By SubXpath =By.xpath("//h2[text()='Subscription']");
    By EmailTextField = By.id("susbscribe_email");
    By SubSendButton = By.id("subscribe");
    By SubSucessMsg = By.xpath("//div[text()='You have been successfully subscribed!']");

    public void Verify_Subcription_field()
    {
        WebElement e  = driver.findElement(SubXpath);
       JavascriptExecutor js= (JavascriptExecutor)driver; 
       js.executeScript("arguments[0].scrollIntoView(true);", e);  
       Assert.assertTrue(e.isDisplayed());    
    }
    public void EnterEmail(){
        WebElement e  = driver.findElement(EmailTextField);
        e.sendKeys("dfivuhru@gmail.com");
        WebElement e2 = driver.findElement(SubSendButton);
        ClickingButtonMethod(e2);
        WebElement e1  = driver.findElement(SubSucessMsg);
        Assert.assertTrue(e1.isDisplayed()); 
    }  
    public void  EnterEmailforSubcription()
    {
        Verify_Subcription_field();
        EnterEmail();

    }                               
}

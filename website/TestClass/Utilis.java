package website.TestClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import website.DriverClass.DriverClass;


public class Utilis {
    public WebDriver driver;
    public String BrowserURl ="https://www.automationexercise.com/";
    @BeforeSuite
    public void launchUrl()
    {
        DriverClass oc = new DriverClass();
        driver =oc.SetDriver();
        driver.get(BrowserURl);
        //WaitForURL(BrowserURl);
    }
    @BeforeTest
    public void WaitForURL() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.urlToBe(BrowserURl));
        System.out.println("URL is Passed");
        Assert.assertEquals(BrowserURl, driver.getCurrentUrl());
        GetTitle();
    }

  //  @AfterTest
    public void DriverCloseMethod()
    {
        if(driver!=null)
        {
            driver.close();
        }
    }
    public void GetTitle() {
        Assert.assertEquals(driver.getTitle(),"Automation Exercise");
        System.out.println("Title is Passed");
    }
}

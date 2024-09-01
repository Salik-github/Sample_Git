package website.PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TestCase7Page extends CommonPageMethod {

    public TestCase7Page(WebDriver driver) {
        super(driver);
    }

    public void VerifyTestCasePage_Opened()
    {
        Clicking_TestCasePage_Button();
    }

    By TestCaseXpath = By.xpath(" //a[text()=' Test Cases']");

    public void Clicking_TestCasePage_Button()
    {
        WebElement e =  driver.findElement(TestCaseXpath);
        ClickingButtonMethod(e);
        Assert.assertEquals(driver.getCurrentUrl(),SetDateMethodFromProperty("testcasepageurl"));
    }


    
}

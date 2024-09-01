package website.PageClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TestCase3Page extends CommonPageMethod {
 
   public TestCase3Page (WebDriver driver)
    {
      super(driver);
    }
        By PasswordXpath = By.xpath("//input[@type='password']");
        By InValiXpath= By.xpath("//p[text()='Your email or password is incorrect!']");
        private final  static  String EmailText = "(//input[@name='email'])";
        @FindBy(xpath = EmailText)
        List<WebElement> EmailTextBox;

    public void InvalidEmailEnter()
    {
        EnterEmail(SetDateMethodFromProperty("invalidEmail"),"old");
        EnterPassword();
        ClickingLoginButton();
        VeirifyWrongMessage();

    }
    public void VeirifyWrongMessage()
    {
        WebElement e  = driver.findElement(InValiXpath);
        Assert.assertTrue(e.isDisplayed());
    }
    
    
}

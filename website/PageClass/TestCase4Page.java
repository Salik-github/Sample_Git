package website.PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TestCase4Page extends CommonPageMethod {

   

    public TestCase4Page (WebDriver driver)
    {
        super(driver);
    }

    By LogoutXpath =By.xpath("//i[@class='fa fa-lock']");
    public void LoginWithExitingAccount()
    {
        ClickingSignupHomeButton_ForOldUser();
        EnterEmail(SetDateMethodFromProperty("validEmail"),"old");
        EnterPassword();
        ClickingLoginButton();
        verifyLogged();
    }
    public void ClickingLogout()
    {
        WebElement e  = driver.findElement(LogoutXpath);
        ClickingButtonMethod(e);
    }
    public void VerifyinLoginPage()
    {
        String URL ="https://www.automationexercise.com/login";
        Assert.assertEquals(URL, driver.getCurrentUrl());
    }
    public void LogoutAccount()
    {
     ClickingLogout();
     VerifyinLoginPage  ();
    }  

    public void LoggingWithExitingEmail(){

        ClickingSignupHomeButton_WithVerifyHeading();
        EnterNewName((SetDateMethodFromProperty("name")));
        EnterEmail(SetDateMethodFromProperty("validEmail"),"New");
        ClickingSignupButton();
        VerifyAlreadyEmailExistShowing();


    }
    
    By SignupButton =By.xpath("//button[text()='Signup']");

    public  void ClickingSignupButton()
    {
        WebElement e = driver.findElement(SignupButton);
        e.click();
    }
    By AlreadyEmailhaveMessage =By.xpath("//p[text()='Email Address already exist!']");
    public void VerifyAlreadyEmailExistShowing()
    {
       WebElement e  = driver.findElement(AlreadyEmailhaveMessage);
       Assert.assertTrue(e.isDisplayed());

    }


    
}

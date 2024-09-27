package ToolShopDemo.WebsitePage.PageFunction;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import ToolShopDemo.WebsitePage.PageObject.SigninPage;

public class SigninPageAction extends SigninPage {

    public SigninPageAction(WebDriver driver) {
        super(driver);
    }

    public void EnterEmailandPassword(String UserName, String Password) {
        EnterEmail(UserName);
        EnterPassword(Password);
    }

    public void ClickingLoginButton() {
        ClickingLoginButtonin_SiginPage();
        if (driver.getCurrentUrl().equals("https://practicesoftwaretesting.com/auth/login")) {
            if (SiginErroMessage.get(0).getText().equals("Email is required")) {
                VerifyWithoutFllingSigin();
            } else
            {
                WrongUserNameAndPasswordErrorMessage();
            }
        }

    }

    public void VerifyGoogleWindow()
    {
        ClikingSiginWithgoogleXpath();
        String MainWindow =driver.getWindowHandle();
        Set<String> AllWindow = driver.getWindowHandles();
        for(String window :AllWindow)
        {
            if(!window.equals(MainWindow))
            {
                System.out.println("SigninWithGoogleWindowOpened");
                driver.switchTo().window(window);
                break;
            }
        }
    }
    public void VerfiyForgotPasswordPage()
    {
      String forgotpageURL = clickForgotPasswordButton();
      Assert.assertEquals("https://practicesoftwaretesting.com/auth/forgot-password", forgotpageURL);
      EnterEmail("99mohamedsdsf@gmail.com");
      ClickingSetPasswordBtn();
      //Assert.assertTrue(ErrorMesssage.isDisplayed());
    }
}

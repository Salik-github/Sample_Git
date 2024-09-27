package ToolShopDemo.WebsitePage.PageFunction;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import ToolShopDemo.WebsitePage.PageObject.HomePage;
import ToolShopDemo.WebsitePage.PageObject.SigninPage;
import ToolShopDemo.WebsitePage.PageObject.SignupPage;

public class SignupPageAction extends SignupPage {
    SigninPage oc;
    HomePage homePageObject;
    String Email;

    public SignupPageAction(WebDriver driver) {
        super(driver);
        oc = new SigninPage(driver);
        homePageObject = new HomePage(driver);
    }

    public void LandingSignupPage() {
        homePageObject.ClickingSigninButton_And_Verify();
       
    }
    public void ClickingRegisterYourAccountM()
    {
        oc.ClickingRegisterYourAccount();
    }

    public void UserDetailsforSignun() {

        Random oc = new Random();
        int r = oc.nextInt(100);
        EnterFirstName(SetDateMethodFromProperty("firstname"));
        EnterLastName(SetDateMethodFromProperty("lastname"));
        EnterDob(SetDateMethodFromProperty("dob"));
        EnterAddress(SetDateMethodFromProperty("address"));
        EnterPostcode(SetDateMethodFromProperty("postcode"));
        EnterCity(SetDateMethodFromProperty("city"));
        EnterState(SetDateMethodFromProperty("state"));
        EnterCountry(SetDateMethodFromProperty("country"));
        EnterPhone(SetDateMethodFromProperty("phone"));
        Email= r + SetDateMethodFromProperty("email");
        System.out.println(Email);
        EnterEmail(Email);
        EnterPassword(SetDateMethodFromProperty("password"));
    }

    public void ClickingRegister() {

        String URL = ClickRegisterButton();
        String SuccessURL = "https://practicesoftwaretesting.com/auth/login";
        String SameURL = "https://practicesoftwaretesting.com/auth/register";
        if (URL.equals(SuccessURL)) {
            System.out.println("SuccessFully Registered ");
        } else if (URL.equals(SameURL)) {
            if ("First name is required".equals(SmallValidationMessage.get(0).getText())) {
                System.out.println("This is error");
                GetSmallValidationMessage();
                GetLargeValidationMessage();
            } else if (ErrorMesssage.isDisplayed()) {
                Assert.assertTrue(ErrorMesssage.isDisplayed());
                System.out.println(ErrorMesssage.getText());

            }
        }
    }

}

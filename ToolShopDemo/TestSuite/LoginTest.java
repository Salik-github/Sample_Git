package ToolShopDemo.TestSuite;

import org.testng.annotations.Test;

import ToolShopDemo.WebsitePage.PageFunction.SigninPageAction;
import ToolShopDemo.WebsitePage.PageFunction.SignupPageAction;

public class LoginTest extends UtilsTest {

    // SignUpTestCase
    @Test
    public void SignUpTest_One() {

        SignupPageAction pc = new SignupPageAction(driver);
        pc.LandingSignupPage();
        pc.ClickingRegisterYourAccountM();
        pc.UserDetailsforSignun();
        pc.ClickingRegister();

    }

    @Test
    public void Enter_RegiterButton_Without_Filled() {
        SignupPageAction pc = new SignupPageAction(driver);
        pc.LandingSignupPage();
        pc.ClickingRegisterYourAccountM();
        pc.ClickingRegister();
    }

    @Test
    public void Enter_UserName_Password_Correctly() {
        SigninPageAction SPA = new SigninPageAction(driver);
        SignupPageAction pc = new SignupPageAction(driver);
        pc.LandingSignupPage();
        String Email = "99mohamedsdsf@gmail.com";
        String Password  ="Welcome2024!!";
        SPA.EnterEmailandPassword(Email,Password);
        SPA.ClickingLoginButton();
    }
   
    @Test
    public void Without_Enter_UserName_Password() {
        SigninPageAction SPA = new SigninPageAction(driver);
        SignupPageAction pc = new SignupPageAction(driver);
        pc.LandingSignupPage();
        SPA.ClickingLoginButton();

    }
    @Test 
    public void VerfiySiginWithGoogleWindow(){
        SigninPageAction SPA = new SigninPageAction(driver);
        SignupPageAction pc = new SignupPageAction(driver);
        pc.LandingSignupPage();
        SPA.VerifyGoogleWindow();
    }
    @Test
    public void VerifyForgotPassowrd()
    { SigninPageAction SPA = new SigninPageAction(driver);
        SignupPageAction pc = new SignupPageAction(driver);
        pc.LandingSignupPage();
        SPA.VerfiyForgotPasswordPage();
    }
}
// 99mohamedsdsf@gmail.com
// 
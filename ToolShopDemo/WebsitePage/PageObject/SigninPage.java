package ToolShopDemo.WebsitePage.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ToolShopDemo.WebsitePage.PageFunction.CommonPageAction;

public class SigninPage extends CommonPageAction {

    public SigninPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        // CPA = new CommonPageAction(driver);
    }

    @FindBy(xpath = "//button[text()=' Sign in with Google ']")
    public WebElement SigninWithGoogle;
    @FindBy(id = "email")
    public WebElement EmailTextBox;
    @FindBy(xpath = "//input[@class='form-control']")
    public WebElement PasswordTextBox;
    @FindBy(xpath = "//button[@class='btn btn-outline-secondary']")
    public WebElement PasswordUnhide;
    @FindBy(xpath = "//input[@class='btnSubmit']")
    public WebElement LoginButton;
    @FindBy(xpath = "//a[text()='Register your account']")
    private WebElement RegisterButton;
    @FindBy(xpath = "//a[text()='Forgot your Password?']")
    private WebElement ForgotPasswordButton;
    public final String Sigin = "//div[@class='alert alert-danger']";
    @FindBy(xpath = Sigin)
    public List<WebElement> SiginErroMessage;
    @FindBy(xpath="//button[@class='google-sign-in-button']")
    WebElement SiginWithGoogle;
    @FindBy(xpath = "//input[@class='btnSubmit']")
    WebElement SetNewPasswordButton;
    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement ErrorMesssage;

    // Invalid email or password
    //
    public void ClickingSigninWithGoogle() {
        ClickButton(SigninWithGoogle);
    }

    public void EnterEmail(String Email) {
        SendkeysMethod(EmailTextBox, Email);
    }

    public void EnterPassword(String password) {

        SendkeysMethod(PasswordTextBox, password);
        ClickButton(PasswordUnhide);
        Assert.assertEquals(PasswordTextBox.getAttribute("type"), "text");
    }

    public void ClickingLoginButtonin_SiginPage() {
        ClickButton(LoginButton);
    }

    public void VerifyWithoutFllingSigin() {
        Assert.assertEquals(SiginErroMessage.get(0).getText(), "Email is required");
        Assert.assertEquals(SiginErroMessage.get(1).getText(), "Password is required");

    }

    public void WrongUserNameAndPasswordErrorMessage() {
        Assert.assertEquals(SiginErroMessage.get(0).getText(), "Invalid email or password");
        System.out.println(SiginErroMessage.get(0).getText());
    }

    public void ClickingRegisterYourAccount() {
        ClickButton(RegisterButton);
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicesoftwaretesting.com/auth/register");
    }
    public void ClikingSiginWithgoogleXpath()
    {
        ClickButton(SiginWithGoogle);
    }
    public String  clickForgotPasswordButton()
    {
        ClickButton(ForgotPasswordButton);
        return driver.getCurrentUrl();
    }
    public void ClickingSetPasswordBtn()
    {
        ClickButton(SetNewPasswordButton);
    }

}

package ToolShopDemo.WebsitePage.PageObject;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ToolShopDemo.WebsitePage.PageFunction.CommonPageAction;

public class SignupPage extends CommonPageAction {

    public SignupPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first_name")
    public WebElement FirstName;
    @FindBy(id = "last_name")
    public WebElement LastName;
    @FindBy(id = "dob")
    public WebElement Dob;
    @FindBy(id = "address")
    public WebElement Address;
    @FindBy(id = "postcode")
    public WebElement Postcode;
    @FindBy(id = "city")
    public WebElement City;
    @FindBy(id = "state")
    public WebElement State;
    @FindBy(id = "country")
    public WebElement Country;
    @FindBy(id = "phone")
    public WebElement Phone;
    @FindBy(id = "email")
    public WebElement Email;
    @FindBy(xpath = "//input[@class='form-control']")
    public WebElement Password;
    @FindBy(xpath = "//button[text()='Register ']")
    public WebElement RegisterButton;
    @FindBy(xpath = "//div[@class='help-block']")
    public WebElement ErrorMesssage;
    public final String SM = "//div[@class='alert alert-danger']";
    @FindBy(xpath = SM)
    protected List<WebElement> SmallValidationMessage;
    public final String LM = "//div[@class='alert alert-danger mt-3']";
    @FindBy(xpath = LM)
    protected List<WebElement> LargeValidationMessage;

    public void EnterFirstName(String firstName) {
        SendkeysMethod(FirstName, firstName);
    }

    public void EnterLastName(String lastName) {
        SendkeysMethod(LastName, lastName);
    }

    public void EnterDob(String dob) {
        SendkeysMethod(Dob, dob); // Ensure date format is correct (yyyy-MM-dd)
    }

    public void EnterAddress(String address) {
        SendkeysMethod(Address, address);
    }

    public void EnterPostcode(String postcode) {
        SendkeysMethod(Postcode, postcode);
    }

    public void EnterCity(String city) {
        SendkeysMethod(City, city);
    }

    public void EnterState(String state) {
        SendkeysMethod(State, state);
    }

    public void EnterCountry(String country) {
        SelectByValue(Country, "");
    }

    public void EnterPhone(String phone) {
        SendkeysMethod(Phone, phone);
    }

    public void EnterEmail(String email) {
        SendkeysMethod(Email, email);
    }

    public void EnterPassword(String password) {
        SendkeysMethod(Password, password);
    }

    public String ClickRegisterButton() {
        ClickButton(RegisterButton);
        new WebDriverWait(driver, Duration.ofSeconds(3000))
                .until(ExpectedConditions.urlToBe("https://practicesoftwaretesting.com/auth/login"));
       
        Assert.assertEquals(driver.getCurrentUrl(),"https://practicesoftwaretesting.com/auth/login");
        return driver.getCurrentUrl();
    }

    public void Count() {
        SelectByValue(Country, "re");
    }

    public void GetSmallValidationMessage() {
        Assert.assertEquals("First name is required", SmallValidationMessage.get(0).getText());
        Assert.assertEquals("fields.last-name.required", SmallValidationMessage.get(1).getText());
        Assert.assertEquals("Postcode is required", SmallValidationMessage.get(2).getText());
        Assert.assertEquals("City is required", SmallValidationMessage.get(3).getText());
        Assert.assertEquals("State is required", SmallValidationMessage.get(4).getText());
        Assert.assertEquals("Country is required", SmallValidationMessage.get(5).getText());
    }

    public void GetLargeValidationMessage() {
        Assert.assertEquals("Date of Birth is required", LargeValidationMessage.get(0).getText());
        Assert.assertEquals("Address is required", LargeValidationMessage.get(1).getText());
        Assert.assertEquals("Phone is required.", LargeValidationMessage.get(2).getText());
        Assert.assertEquals("Email is required", LargeValidationMessage.get(3).getText());
        Assert.assertEquals("Password is required", LargeValidationMessage.get(4).getText());

    }

}

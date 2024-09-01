package website.PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class PlaceOrderRegisterwithCheckoutPage extends ProductQuantityinCartPage {
    
    public PlaceOrderRegisterwithCheckoutPage (WebDriver driver)
    {
        super(driver);
    }
    By CardButtonHomePage =By.xpath("//a[text()=' Cart']");
    By ViewCart = By.xpath("//u[text()='View Cart']");
    By TotalAmt = By.xpath("//p[@class='cart_total_price']");
    By Placeorder =By.xpath("//a[text()='Place Order']");
    @FindBy(xpath ="//input[@class='form-control']")
    WebElement CardName;
    @FindBy(xpath ="//input[@class='form-control card-number']")
    WebElement CardNumber;
    @FindBy(xpath ="//input[@class='form-control card-cvc']")
    WebElement cvc;
    @FindBy(xpath ="//input[@class='form-control card-expiry-month']")
    WebElement ExpriMonth;
    @FindBy(xpath ="//input[@class='form-control card-expiry-year']")
    WebElement ExperYear;
    @FindBy(xpath ="//button[@class='form-control btn btn-primary submit-button']")
    WebElement PayandConfirmButton;
    By OrderSuccess = By.xpath("//b[text()='Order Placed!']");
    @FindBy(xpath="//a[text()='Add to cart']")
    List<WebElement> AddToCardXpath;
    By Checkoutxpath  = By.xpath("//a[@class='btn btn-default check_out']");
    By Register_login= By.xpath("//u[text()='Register / Login']");
    public void ProductAddtoCartFlow()
    {
        ClickingAddToCard();
        ClickingCheckout_inCartPage();
        
    }
    public void SignupFromCart()
    {
        Clicking_Register_login();
        InSignupPageName_Email();
        EnterUserDetailsCommon();
        ClickingCardHomeButton();
    }
    public void AfterLoggedCheckout()
    {
        ClickingCheckout_inCartPage();
        PrintTotalAmount();
        ClickingButtonMethod(driver.findElement(Placeorder));
        PaymentPageFields();
        VerfiyOrderSucces();
        DeletedAccount();
    }
    public void ClickingAddToCard()
    {
         JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900)", "");
        AddToCardXpath.getFirst().click();
        VErify_Added_Aleart();
        ClickingButtonMethod(driver.findElement(ViewCart));
        AssertMethod(driver.getCurrentUrl(), "https://www.automationexercise.com/view_cart");
    }
    public void ClickingCheckout_inCartPage()
    {
        WebElement e  = driver.findElement(Checkoutxpath);
        ClickingButtonMethod(e);
    }
    public void Clicking_Register_login()
    {
        WebElement e  = driver.findElement(Register_login);
        ClickingButtonMethod(e);
    }
    public void ClickingCardHomeButton()
    {
        ClickingButtonMethod(driver.findElement(CardButtonHomePage));
    }
    public void PrintTotalAmount()
    {
        List <WebElement> e = driver.findElements(TotalAmt);
         System.out.println(e.get(e.size()-1).getText());

    }
    public void PaymentPageFields()
    {
        CardName.sendKeys("salik");
        CardNumber.sendKeys("123342133");
        cvc.sendKeys("311");
        ExpriMonth.sendKeys("12");
        ExperYear.sendKeys("2027");
        ClickingButtonMethod(PayandConfirmButton);
    }
    public void VerfiyOrderSucces()
    {
        WebElement e  = driver.findElement(OrderSuccess);
        Assert.assertTrue(e.isDisplayed());
    }

}

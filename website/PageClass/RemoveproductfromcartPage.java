package website.PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RemoveproductfromcartPage extends PlaceOrderBeforeCheckoutPage {

    public RemoveproductfromcartPage(WebDriver driver) {
        super(driver);
        
    }

    @FindBy(xpath = "//a[@class='cart_quantity_delete']")
    WebElement CloseIcon;
    @FindBy(xpath = "//b[text()='Cart is empty!']")
    WebElement CartEmptyMessage;
    public void RemoveProductCart()
    {
        ClickingAddToCard();
        DeleteIteminCart();
    }
    public void DeleteIteminCart()
    {
        ClickingButtonMethod(CloseIcon);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.visibilityOf(CartEmptyMessage));
        Assert.assertTrue(CartEmptyMessage.isDisplayed());
    }

}

package website.PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import java.util.List;


public class ProductQuantityinCartPage extends TestCase1Page {
    
    public  ProductQuantityinCartPage(WebDriver driver)
    {
        super(driver);
    }
    public void View_Product_Add_to_Cart()
    {
        ClickingViewButton();
        Increase_Product_Quantity();
        Add_To_Cart();
        Verfiy_product_Cart();
    }
    
   
    By quantity = By.id("quantity");
    By ViewButton = By.xpath("//a[text()='View Product']");
    By CardButton =By.xpath("//i[@class='fa fa-shopping-cart']");
    By AddedMessage = By.xpath("//h4[text()='Added!']");
    By ContinueShopping =By.xpath("//button[text()='Continue Shopping']");
    By CartQuantity = By.xpath("//td[@class='cart_quantity']");
    
    public void ClickingViewButton() {
        List<WebElement> e = driver.findElements(ViewButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)", "");
        e.getFirst().click();
        Assert.assertEquals(SetDateMethodFromProperty("FirstProductPage"), driver.getCurrentUrl());
    }
    public void Increase_Product_Quantity()
    {       
         WebElement e = driver.findElement(quantity);
         e.clear();
         e.sendKeys(SetDateMethodFromProperty("quantity"));

    }
    public  void  Add_To_Cart()
    {
        List<WebElement> e  = driver.findElements(CardButton);
        ClickingButtonMethod(e.get(1));
    }
        
        public  void  VErify_Added_Aleart()
        {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4000));     
         WebElement e1 = driver.findElement(AddedMessage);
         wait.until(ExpectedConditions.visibilityOf(e1));
         Assert.assertTrue(e1.isDisplayed());
        
        }
    public void Verfiy_product_Cart()
    {
        WebElement e2 = driver.findElement(ContinueShopping);
        ClickingButtonMethod(e2);
        List<WebElement> e  = driver.findElements(CardButton);
        ClickingButtonMethod(e.getFirst());
        WebElement e1 = driver.findElement(CartQuantity);
        Assert.assertEquals(SetDateMethodFromProperty("quantity"), e1.getText());

    }
   

}

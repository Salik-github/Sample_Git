package website.PageClass;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.testng.Assert;

public class TestCase8Page extends CommonPageMethod {

    public TestCase8Page(WebDriver driver) {
        super(driver);
    }

    public void Verify_Product() {
        ClickingProductButton();
        CheckingAllProductVisible();
        ClickingViewButton();
        Verify_product_details_visible();
    }

    By ProductButton = By.xpath("//i[@class='material-icons card_travel']");
    By ImageCard = By.xpath("//div[@class='product-image-wrapper']");
    By ViewButton = By.xpath("//a[text()='View Product']");

    public void ClickingProductButton() {
        WebElement e = driver.findElement(ProductButton);
        ClickingButtonMethod(e);
        Assert.assertEquals(SetDateMethodFromProperty("ProductPage"), driver.getCurrentUrl());
    }

    public void CheckingAllProductVisible() {
        List<WebElement> e = driver.findElements(ImageCard);

        Assert.assertEquals(34, e.size());
    }

    public void ClickingViewButton() {
        List<WebElement> e = driver.findElements(ViewButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
        e.getFirst().click();
        Assert.assertEquals(SetDateMethodFromProperty("FirstProductPage"), driver.getCurrentUrl());
    }

    @FindBy(xpath = "//img[@class='newarrival']/following-sibling::h2")
    WebElement ProductName;
    @FindBy(xpath = "//p[contains(text(),'Category:')]")
    WebElement ProductCategory;
    @FindBy(xpath = "//span[contains(text(),'Rs.')]")
    WebElement ProductRupees;
    @FindBy(id = "quantity")
    WebElement ProductQuantity;
    @FindBy(xpath = "//p[b[contains(text(),'Brand')]]")
    WebElement ProductBrand;

    public void Verify_product_details_visible() {
       Assert.assertTrue(ProductName.isDisplayed());
      PrintTextMethod(ProductName);
        Assert.assertTrue(ProductCategory.isDisplayed());
        PrintTextMethod(ProductCategory);
        Assert.assertTrue(ProductRupees.isDisplayed());
        PrintTextMethod(ProductRupees);
        Assert.assertTrue(ProductQuantity.isDisplayed());
        System.out.println(ProductQuantity.getAttribute("value"));
        Assert.assertTrue(ProductBrand.isDisplayed());
        PrintTextMethod(ProductBrand);
    }

    public void PrintTextMethod(WebElement e) {
        System.out.println(e.getText());
    }

}

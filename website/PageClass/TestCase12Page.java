package website.PageClass;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TestCase12Page extends CommonPageMethod {
    
    public TestCase12Page(WebDriver driver)
    {
        super(driver);
    }

    By ProductButton = By.xpath("//i[@class='material-icons card_travel']");
    By ImageCard = By.xpath("//div[@class='product-image-wrapper']");

    public void Add_Cart_Product()
    {
        ClickingProductButton();
        CheckingAllProductVisible();

    }
    public void ClickingProductButton() {
        WebElement e = driver.findElement(ProductButton);
        ClickingButtonMethod(e);
        Assert.assertEquals(SetDateMethodFromProperty("ProductPage"), driver.getCurrentUrl());
    }
    public void CheckingAllProductVisible() {
        List<WebElement> e = driver.findElements(ImageCard);

        Assert.assertEquals(34, e.size());
    }

}

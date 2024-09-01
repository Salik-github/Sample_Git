package website.PageClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase9Page extends CommonPageMethod {
    
    public TestCase9Page(WebDriver driver)
    {
        super(driver);
    }
    By Search_Product = By.id("search_product");
    By SearchIcon = By.id("submit_search");
    By SearchList = By.xpath("//div[@class='overlay-content']/p[contains(text(), 'T')]");

    public void Search_Box()
    {
        WebElement e  = driver.findElement(Search_Product);
        e.sendKeys(SetDateMethodFromProperty("SearchProduct"));
        WebElement e1  = driver.findElement(SearchIcon);
        ClickingButtonMethod(e1);

    }
    public void SearcbListSize()
    {
        List<WebElement> e  = driver.findElements(SearchList);
        System.out.println(e.size());
    }
    public void SearchingProduct()
    {
        Search_Box();
        SearcbListSize();
        
    }
}

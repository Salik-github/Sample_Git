package ToolShopDemo.WebsitePage.PageFunction;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ToolShopDemo.WebsitePage.PageObject.HomePage;

public class HomePageAction extends HomePage {

    // public WebDriver driver;
    public HomePageAction(WebDriver driver) {
        super(driver);
    }

    public void VerifyHomePageLanded() {
        ClickingHomeButton();
        Assert.assertEquals(driver.getCurrentUrl(), SetDateMethodFromProperty("url"));
    }

    public void CheckSortFilter() {
        SortFilterAction("1", "index");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.textToBePresentInElement(
                ProductHeading.get(1), "Adjustable Wrench"));
    }

    public void CheckingSortingItem()   {
        List<String> OriginalName = new ArrayList<>();
        List<String> SortedName = new ArrayList<>();

       

        for (int i = 0; i < ProductHeading.size(); i++) {
            OriginalName.add(ProductHeading.get(i).getText());

        }
        SortedName.addAll(OriginalName);
        Collections.sort(SortedName);

        for (int i = 0; i < ProductHeading.size(); i++) {
            if (!OriginalName.get(i).equals(SortedName.get(i))) {
                System.out.println("Not Sorted Properlyu ");
            }
        }

    }

}

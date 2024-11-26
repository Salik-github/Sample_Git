package projects.pages;

import Data.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage
{
    private final By RevenueCalculatorButton = By.xpath("//div[text()='Revenue Calculator']");

    public HomePage(WebDriver driver) {

        super(driver);
    }
    public void ClickingAndVerifyTheRevenuePage()
    {
        ClickingRevenueButton();
        VerifyRevenuePage();
    }

    public  void ClickingRevenueButton()
    {
      clickButton(RevenueCalculatorButton);
    }
    public  void VerifyRevenuePage()
    {
        waitForURL(Constants.REVENUECALCULATOREURL);
        expectedAssert(Constants.REVENUECALCULATOREURL,driver.getCurrentUrl());
        System.out.println("RevenueCalculator page redirected successfully ");
    }


}


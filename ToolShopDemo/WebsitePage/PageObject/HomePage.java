package ToolShopDemo.WebsitePage.PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ToolShopDemo.WebsitePage.PageFunction.CommonPageAction;

public class HomePage extends CommonPageAction {
    // public WebDriver driver;
    public CommonPageAction CPA;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Home']")
    public WebElement HomeButton;
    @FindBy(xpath = "//a[text()=' Categories ']")
    private WebElement CategoriesButton;
    @FindBy(xpath = "//a[text()='Contact']")
    private WebElement ContactButton;
    @FindBy(xpath = "//a[text()='Sign in']")
    private WebElement SiginButton;
    @FindBy(xpath = "//select[@class='form-select']")
    private WebElement SortByNameAndPrice;
    @FindBy(xpath = "//select[@class='form-select']")
    public WebElement SortFilter;
    private final String Header ="//h5[@class='card-title']";
    @FindBy(xpath = Header)
    public List<WebElement> ProductHeading;

    public void ClickingHomeButton() {
        ClickButton(HomeButton);
    }

    public void ClickingSigin() {
        ClickButton(SiginButton);
    }

    public void ClickingSigninButton_And_Verify() {
        ClickingSigin();
        new WebDriverWait(driver, Duration.ofSeconds(4000))
                .until(ExpectedConditions.urlToBe(SetDateMethodFromProperty("SigiupUrl")));
        Assert.assertEquals(driver.getCurrentUrl(), SetDateMethodFromProperty("SigiupUrl"));
    }

    public void SortFilterAction(String input , String By) {
        SelectBy(SortFilter, input, By);
    }
}

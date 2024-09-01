package website.PageClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PageTestCase1 {
    WebDriver driver;
    public PageTestCase1(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    By SignupHomeButton = By.xpath(" //a[text()=' Signup / Login']");
    By NewNameText = By.xpath("//input[@name='name']");
    By SignupButton =By.xpath("//button[text()='Signup']");

    private final  static  String EmailText = "(//input[@name='email'])";
    @FindBy(xpath = EmailText)
    List<WebElement> EmailTextBox;



    public void ClickingSignupHomeButton()
    {
        WebElement e = driver.findElement(SignupHomeButton);
        e.click();
        String loginUrl = "https://www.automationexercise.com/login";
        Assert.assertEquals(driver.getCurrentUrl(),loginUrl);
    }
    public  void EnterNewName(String NewName){
        WebElement e  = driver.findElement(NewNameText);
        e.sendKeys(NewName);
    }
    public  void EnterNewEmail(String NewEmail)
    {
         EmailTextBox.get(2).sendKeys(NewEmail);
    }
    public  void EnterOldEmail(String NewEmail)
    {
        EmailTextBox.getFirst().sendKeys(NewEmail);
    }
    public  void ClickingSignupButton()
    {
        String AfterSignupURL ="https://www.automationexercise.com/signup";
        WebElement e = driver.findElement(SignupButton);
        e.click();
        Assert.assertEquals(driver.getCurrentUrl(),AfterSignupURL);
    }


}

package website.PageClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TestCase6Page extends CommonPageMethod{

    public TestCase6Page(WebDriver driver)
    {
        super(driver);
    }
    By ContactUsXpath = By.xpath("//i[@class='fa fa-envelope']");
    By ContactHeadingVerigfy= By.xpath("//h2[text()='Get In Touch']");
    public final static String xpath ="//input[@class='form-control']";
    @FindBy(xpath = xpath)
    List<WebElement> Contact_Form;

    public void ContactTestCase()
    {
        ClickingContactButton();
        VerifyContactHeading();
        EnterContactForm();
        ClickingSubmitButton();

    }
    public void AfterContactFormSubmit()
    {
        AlertMethodAcceptmenthod();
        VerifySuccessMessage();
        ClickingHomeButton();
        VerifyLandedHomePage();

        
    }
    public void ClickingContactButton()
    {
        WebElement e  = driver.findElement(ContactUsXpath);
        ClickingButtonMethod(e);
    }
    public void VerifyContactHeading()
    {
        WebElement e  = driver.findElement(ContactHeadingVerigfy);
        Assert.assertTrue(e.isDisplayed());
    }
    By messageBoxXpath =By.id("message");
    By SubmitButton =By.xpath("//input[@name='submit']");
    public void EnterContactForm()
    {
        SendKeyMethod(Contact_Form.get(0),SetDateMethodFromProperty("contactFormName"));
        SendKeyMethod(Contact_Form.get(1),SetDateMethodFromProperty("contactFormemail"));
        SendKeyMethod(Contact_Form.get(2),SetDateMethodFromProperty("subject"));
        WebElement e  = driver.findElement(messageBoxXpath);
        SendKeyMethod(e,SetDateMethodFromProperty("message") );
       // SendKeyMethod(Contact_Form.get(3),SetDateMethodFromProperty("filePath"));
        Contact_Form.get(3).sendKeys("C:\\Users\\MY-PC\\SalikVs\\automate\\src\\test\\java\\website\\TestClass\\TestCase1.java");
    }

    public void ClickingSubmitButton()
    {
        WebElement e  = driver.findElement(SubmitButton);
        WebElement wait  = new WebDriverWait(driver, Duration.ofSeconds(3000)).until(ExpectedConditions.elementToBeClickable(e));
        ClickingButtonMethod(wait);
    }
    By SucessfulyXpath = By.xpath("//div[@class='status alert alert-success']");

    public void VerifySuccessMessage()
    {
        WebElement e  = driver.findElement(SucessfulyXpath);
        Assert.assertTrue(e.isDisplayed());
    }
    By Homexpath =By.xpath("//span[text()=' Home']");

    public void ClickingHomeButton()
    {
        WebElement e  = driver.findElement(Homexpath);
        ClickingButtonMethod(e);
    }
    void VerifyLandedHomePage()
    {
        String Url ="https://www.automationexercise.com/";
        Assert.assertEquals(Url, driver.getCurrentUrl());
    }
    
    
}

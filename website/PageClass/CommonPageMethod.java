package website.PageClass;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CommonPageMethod {

    WebDriver driver;
    public CommonPageMethod(WebDriver driver) {
         this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    
    By LoggedVerifyText = By.xpath("//i[@class='fa fa-user']");

    private final  static  String EmailText = "(//input[@name='email'])";
    @FindBy(xpath = EmailText)
    List<WebElement> EmailTextBox;
    public static final String LoginB ="//button[@type='submit']";
    @FindBy(xpath =LoginB )
    List<WebElement>Login_SignupButton;
    public void ClickingButtonMethod(WebElement clickingElement)
    {
        clickingElement.click();
    }
    public void SendKeyMethod(WebElement GM,String SendkeysString )
    { 
      GM.sendKeys(SendkeysString);   
    }
    public static String  SetDateMethodFromProperty(String Key)
    {
        Properties oc = new Properties();
        try{
            oc.load(new FileInputStream("src\\test\\java\\website\\PageClass\\data.properites"));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return oc.getProperty(Key);
    }
    public void ClickingLoginButton()
    {
        ClickingButtonMethod(Login_SignupButton.getFirst());

    }
        By PasswordXpath = By.xpath("//input[@type='password']");

    public void EnterPassword()
    {
       WebElement e  = driver.findElement(PasswordXpath);
       SendKeyMethod(e,SetDateMethodFromProperty("password"));
    }
    By SignupHomeButton = By.xpath(" //a[text()=' Signup / Login']");
    By OldUserWord = By.xpath("//h2[text()='Login to your account']");
    By NewUserWord = By.xpath("//h2[text()='New User Signup!']");

    
    public void ClickingSignupHomeButton_ForOldUser()
    {
        WebElement e = driver.findElement(SignupHomeButton);
        e.click();
        String loginUrl = "https://www.automationexercise.com/login";
        Assert.assertEquals(driver.getCurrentUrl(),loginUrl);
        WebElement e1 = driver.findElement(OldUserWord);
        Assert.assertTrue(e1.isDisplayed());
    }
    public  void EnterEmail(String NewEmail, String CheckEmail)
    {
        if(CheckEmail.equals("New"))
        {
            EmailTextBox.get(1).sendKeys(NewEmail);
        }
        else{
            EmailTextBox.getFirst().sendKeys(NewEmail);
        }
    }
    public void verifyLogged()
    {
        WebElement e1 = driver.findElement(LoggedVerifyText);
        Assert.assertTrue(e1.isDisplayed());
    }
    public void ClickingSignupHomeButton_WithVerifyHeading()
    {
        WebElement e = driver.findElement(SignupHomeButton);
        e.click();
        String loginUrl = "https://www.automationexercise.com/login";
        Assert.assertEquals(driver.getCurrentUrl(),loginUrl);
        WebElement e1 = driver.findElement(NewUserWord);
        Assert.assertTrue(e1.isDisplayed());
    }
    By NewNameText = By.xpath("//input[@name='name']");

    public  void EnterNewName(String NewName){
        WebElement e  = driver.findElement(NewNameText);
        e.sendKeys(NewName);
    }

    public void AlertMethodAcceptmenthod()
    {
        driver.switchTo().alert().accept();;

    }
    By Cart = By.xpath("//a[text()=' Cart']");
    public void ClickingCardButton()
    {
        WebElement e  = driver.findElement(Cart);
        ClickingButtonMethod(e);

    }

    public void AssertMethod(String act ,String Exp)
    {
        Assert.assertEquals(act, Exp);
    }
    
}


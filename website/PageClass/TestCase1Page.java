package website.PageClass;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.Random;

public class TestCase1Page extends CommonPageMethod {

    public TestCase1Page (WebDriver driver)
    {
       super(driver);
    }
    By SignupHomeButton = By.xpath(" //a[text()=' Signup / Login']");
    By NewUserWord = By.xpath("//h2[text()='New User Signup!']");
    By NewNameText = By.xpath("//input[@name='name']");
    By SignupButton =By.xpath("//button[text()='Signup']");
    By AccountHeading  =By.xpath("//b[text()='Enter Account Information']");

  
    private final static String RadioXpath ="//div[@class='radio']";
    @FindBy(xpath = RadioXpath)
    List<WebElement> RadionButton;
   
    By Password = By.id("password");
    By texttt =By.xpath("//label[text()='Sign up for our newsletter!']");
    By text2 = By.xpath("//label[text()='Receive special offers from our partners!']");


    @FindBy(id = "first_name")
    WebElement FirstNameText;
    @FindBy(id = "last_name")
    WebElement LastNameText;
    @FindBy(id = "company")
    WebElement CompanyNameText;
    @FindBy(id = "address1")
    WebElement AddressText;
    @FindBy(id = "country")
    WebElement Country ;
    @FindBy(id = "state")
    WebElement StateText;
    @FindBy(id = "city")
    WebElement CityText;
    @FindBy(id = "zipcode")
    WebElement ZipcodeText;
    @FindBy(id = "mobile_number")
    WebElement MobileNumer;

   public void InSignupPageName_Email()
   {
    EnterNewName(SetDateMethodFromProperty("name"));
    Random n = new Random();
    int n1 = n.nextInt(10);  
    String Email ="Mohammed"+n1+"sa@gmail.com";
    EnterEmail(Email,"New");
    
    ClickingSignupButton();
   // ClickingRediobuttonforTitle("0");
  //  ClickingRediobuttonforDeclare(0);

   }
   public void EnterUserDetailsCommon()
    {
        ClickingRediobuttonforTitle("Mr");
        SetPassword();
        SelectingDOB("20", "January","2003");
     //   ClickingRediobuttonforDeclare(0);
        User_Information();
        ClickingCreatedAccountButton();
    }
    

   public void User_Information()
    {
        FirstNameText.sendKeys(SetDateMethodFromProperty("firstName"));
        LastNameText.sendKeys(SetDateMethodFromProperty("lastName"));
        CompanyNameText.sendKeys(SetDateMethodFromProperty("companyName"));
        AddressText.sendKeys(SetDateMethodFromProperty("address"));
        SelectMethod(Country,SetDateMethodFromProperty("country"));
        StateText.sendKeys(SetDateMethodFromProperty("state"));
        CityText.sendKeys(SetDateMethodFromProperty("city"));
        ZipcodeText.sendKeys(SetDateMethodFromProperty("zipcode"));
        MobileNumer.sendKeys(SetDateMethodFromProperty("mobileNumber"));
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
    

    public  void ClickingSignupButton()
    {
        String AfterSignupURL ="https://www.automationexercise.com/signup";
        WebElement e = driver.findElement(SignupButton);
        e.click();
        Assert.assertEquals(driver.getCurrentUrl(),AfterSignupURL);
        WebElement e1 = driver.findElement(AccountHeading);
        Assert.assertTrue(e1.isDisplayed());
    }
    public void ClickingRediobuttonforTitle(String Title)
    {
        if(Title.equals("Mr"))
        {
            RadionButton.getFirst().click();
        }
        else if(Title.equals("Mrs")){
            RadionButton.get(1).click();
        }
    }
    public void ClickingRediobuttonforDeclare(int a)
    {
        if(a==0)
        {
           WebElement e  = driver.findElement(texttt);
           e.click();
           // DeclareRadionButton.getFirst().click();
        }
        else{
            WebElement e  = driver.findElement(texttt);
            e.click();
            WebElement e1  = driver.findElement(text2);
            e1.click();
           
        }
    }
    public void SetPassword()
    {
        WebElement e = driver.findElement(Password); 
        e.sendKeys(SetDateMethodFromProperty("password"));
       
    }
    public void SelectingDOB(String Idate, String Imonth , String Iyear)
    {
        WebElement date = driver.findElement(By.id("days"));
        SelectMethod(date,Idate);
        WebElement month = driver.findElement(By.id("months"));
        SelectMethod(month,Imonth);
        WebElement years = driver.findElement(By.id("years"));
        SelectMethod(years,Iyear);
    }

    public void SelectMethod(WebElement select , String SelectValue)
    {
        Select oc = new Select(select);
        oc.selectByVisibleText(SelectValue);
    }
    By CreateAccButton=By.xpath("//button[text()='Create Account']");
    By CreatedMessages = By.xpath("//h2[@class='title text-center']");
    public void ClickingCreatedAccountButton()
    {
        WebElement e  = driver.findElement(CreateAccButton);
        ClickingButtonMethod(e);
        WebElement e1  = driver.findElement(CreatedMessages);
        Assert.assertTrue(e1.isDisplayed());
        ClickingContinueButton();
        verifyLogged();
    }   
    By ConitueButtonXpath= By.xpath("//a[@class='btn btn-primary']");
    public void ClickingContinueButton()
    {
        WebElement e = driver.findElement(ConitueButtonXpath);
        ClickingButtonMethod(e);
    }
 
    
    By DeletedButton = By.xpath("//i[@class='fa fa-trash-o']");
    public void DeletedAccount()
    {
     WebElement e  = driver.findElement(DeletedButton);
     ClickingButtonMethod(e);
     WebElement e1  = driver.findElement(CreatedMessages);
        Assert.assertTrue(e1.isDisplayed());
        ClickingContinueButton();
    }
}

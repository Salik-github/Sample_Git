package com.frameworks.projectCMS.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class signin {
    WebDriver driver;
    public By inputFirstname = By.id("first_name");
    public By inputLastname = By.id("last_name");
    public By radioOrg = By.id("type_organization");
    public By inputCompanyName = By.id("company_name");
    public By inputEmail = By.id("email");
    public By inputPassword = By.id("password");
    public By inputRePassword = By.id("retype_password");
    public By radioInd = By.id("type_person");
    public By linksignup = By.xpath("//button[text()='Sign up']");
    public By LinksignIn = By.xpath("//a[text()='Sign in']");


    @Test
    public void testcaseOne() {
        driver = new ChromeDriver();
        driver.get("https://rise.anhtester.com/signup");
        driver.findElement(inputFirstname).sendKeys("thius");
        driver.findElement(radioInd).click();
        driver.findElement(inputEmail).sendKeys("adsf");
        driver.findElement(inputRePassword).sendKeys("123232");
    
      //   Actions actions = new Actions(driver);
      //  actions.scrollByAmount(0, 100);
       // WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30) );
     //   wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(linksignup)));
        driver.findElement(linksignup).click();

    }

    public WebElement BytoWebElement_forEnterData(By by) {

        return driver.findElement(by);

    }
}

package CucumberProject.StepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
   
  WebDriver driver;
@Given("User should navigate to the application URL")
public void userShouldNavigateToTheApplicationURL() {
    driver  = new ChromeDriver();
    
    driver.manage().window().maximize();
}
@And("User click on the login link")
public void userClickOnTheLoginLink() {
    driver.get("https://demoentrilycrm.gaipp.com/signin");
}
@And("User enter the usernaem as salik")
public void userEnterTheUsernaemAsSalik() {
    driver.findElement(By.id("user")).sendKeys("info.entrilyzdvfdv@gmail.com");
}
    
@And("User enter the password as password")
public void userEnterThePasswordAs() {
    driver.findElement(By.id("password")).sendKeys("123456");
}
@When("User click the login button")
public void userClickTheLoginButton() {
    driver.findElement(By.id("submit")).click();;
}

@Then("Login should be success")
public void loginShouldBeSuccess() {
    WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(4000));
    wait.until(ExpectedConditions.urlToBe("https://demoentrilycrm.gaipp.com/crm/dashboard/summary"));
    Assert.assertEquals(driver.getCurrentUrl(),"https://demoentrilycrm.gaipp.com/crm/dashboard/summary");
    System.out.println("Firsts");
}
@And("User enter the usernaem as wrongpasword")
public void userEnterTheUsernaemAsWrongpasword() {
    driver.findElement(By.id("user")).sendKeys("info.entrdfgilyzdvfdv@gmail.com");
}
@And("User enter the password as password1")
public void userEnterThePasswordAsPassword1() {
    driver.findElement(By.id("password")).sendKeys("123456");
}
@Then("Login should be fail")
public void loginShouldBeFail() {
    WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(4000));
    wait.until(ExpectedConditions.urlToBe("https://demoentrilycrm.gaipp.com/sigin"));
    Assert.assertEquals(driver.getCurrentUrl(),"https://demoentrilycrm.gaipp.com/sigin");

    System.out.println("Second");
}
}

  



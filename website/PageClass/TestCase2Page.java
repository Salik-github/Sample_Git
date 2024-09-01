package website.PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TestCase2Page extends CommonPageMethod{

    

    

    public TestCase2Page(WebDriver driver) {
        super(driver);
    }

  

    By CreateAccButton=By.xpath("//button[text()='Create Account']");
    By CreatedMessages = By.xpath("//h2[@class='title text-center']");
  
}
   

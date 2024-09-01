package website.DriverClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverClass {
    
    WebDriver driver;

    public WebDriver  SetDriver()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        return driver;
    }

    public void BrowserClose()
    {
        if(driver!=null)
        {
            driver.quit();
        }
    }
}

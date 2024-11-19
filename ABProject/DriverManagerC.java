package ABProject;

import org.openqa.selenium.WebDriver;

public class DriverManagerC
{
    private  static  ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static  void SetDriver(WebDriver driverInstance)
    {
        driver.set(driverInstance);
    }
    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void removeDriver() {
        driver.remove();
    }
    public  static  void Redriver()
    {

    }
}

package ToolShopDemo.WebsitePage.PageFunction;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPageAction {

    public WebDriver driver;

    public CommonPageAction(WebDriver driver) {
        this.driver = driver;
    }

    public void ClickButton(WebElement element) {
        element.click();
    }

    public void SendkeysMethod(WebElement element, String Value) {
        element.sendKeys(Value);
    }

    public static String SetDateMethodFromProperty(String Key) {
        Properties oc = new Properties();
        try {
            oc.load(new FileInputStream("src\\test\\java\\ToolShopDemo\\Utils\\Data.properties"));
        } catch (Exception e) {
            System.out.println(e);
        }
        return oc.getProperty(Key);
    }

    public void WaitMethod(WebElement webelement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.elementToBeClickable(webelement));
    }

    public void SelectByValue(WebElement element, String Value) {
        Select select = new Select(element);
        select.selectByIndex(1);
    }
    public void SelectBy(WebElement element, String input , String type)
    {        Select select = new Select(element);

       switch (type.toLowerCase()) {
        case "Value":
        if(type.equalsIgnoreCase("Value")){
         select.selectByValue(input);
        }
        break;
        case "Index":
        if(type.equalsIgnoreCase("Index")){
            select.selectByIndex(Integer.parseInt(input));
           }
            break;
       case "Text":
       if(type.equalsIgnoreCase("Text")){
        select.selectByVisibleText(input);
       }
       break;
       default:
        if(type.equalsIgnoreCase("Index")){
            select.selectByIndex(Integer.parseInt(input));
           }
            break;
       }
    }

}

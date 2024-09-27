package ToolShopDemo.TestSuite;

import java.io.File;
import java.time.Duration;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;

import ToolShopDemo.Utils.SetDriver;

public class UtilsTest extends SetDriver {

    public WebDriver driver;

    @BeforeSuite
    public void GetDriverMethod() {
        this.driver = SetDriverforBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
        HomePageSetURl();
    }

    public void HomePageSetURl() {
        driver.get("https://practicesoftwaretesting.com/");
        Wait_for_Url_Title();
    }

    public void Wait_for_Url_Title() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
            wait.until(ExpectedConditions.urlToBe("https://practicesoftwaretesting.com/"));
            wait.until(ExpectedConditions.titleIs("Practice Software Testing - Toolshop - v5.0"));
        } catch (Exception e) {
            System.out.println("Url and Title" + e);
        }
    }

    @AfterMethod
    public void SendEmailAfterTest(ITestResult result) throws EmailException
    {
        if(result.getStatus()==ITestResult.SUCCESS)
        {
           // SendEmail ("Test Pass");
        }
        else if  (result.getStatus()==ITestResult.FAILURE)
        {
           // SendEmail ("Test FAil");
        }
        else{
           // SendEmail ("Test unable to find Status");
        }
        
    }
    public void SendEmail (String Status ) throws EmailException
    {
         GenerateReport();
         System.out.println("Start");
         Email email = new SimpleEmail();
         email.setHostName("smtp.gmail.com");
         email.setSmtpPort(465);
         email.setAuthenticator(new DefaultAuthenticator("saliktestqa@gmail.com", "epllztnzsfwzeuqh"));
         email.setSSLOnConnect(true);
         email.setFrom("saliktestqa@gmail.com");
         email.setSubject("Nothing for Test");
         email.setMsg(Status);
         email.addTo("mohammadsalikcse@gmail.com");
         email.send();
         System.out.println("Finish");
        
    }
    public void GenerateReport()
    {         System.out.println("Start G");

        ExtentReports reports = new ExtentReports();
        File file = new File("ToolShopDemo.TestWebsiteReport.html");
        file.getAbsolutePath();
         
         ExtentSparkReporter extent = new ExtentSparkReporter(file);
         reports.attachReporter(extent);
         ExtentTest test = reports.createTest("New Test");
         test.log(Status.PASS, "This test is Passed");
         System.out.println("Start F"  +file.getAbsolutePath());
         reports.flush();

    }

    @AfterSuite
    public void QuitDriverMethod() {
        QuitDriver();
    }

}

package ABProject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.Map;


public class TestCaseClass extends ExtentReportsClass {


    public WebDriver GetDesireTestMethod(String URL) {
        WebDriver driver = new ChromeDriver();
        DriverManagerC.SetDriver(driver);
        driver.get(URL);
        return driver;
    }

    @BeforeMethod
    public void checkIfTestShouldRun(ITestContext context , ITestResult result) {

        Map<String, String> para  = result.getMethod().findMethodParameters(context.getCurrentXmlTest());
        String paraem = para.get("skipReason");
        if(paraem!=null)
        {
            result.setStatus(ITestResult.SKIP);
            ITestListener listener = new ItestListenerClass();
            listener.onTestSkipped(result);
            return;
        }
    }

    @Test
    public void TestCaseOne() {

        WebDriver driver = GetDesireTestMethod("https://demoentrilycrm.gaipp.com/crm");
        // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        Assert.assertEquals("Entrily", driver.getTitle());
        driver.close();
    }

    @Test
    public void TestCaseTwo() {
        WebDriver driver = GetDesireTestMethod("https://www.demoabroadedu.gaipp.com/signin");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        Assert.assertEquals("https://www.demoabroadedu.gaipp.com/sign", driver.getCurrentUrl());
        driver.close();
    }

    @Test
    public void TestCaseThree() {
        WebDriver driver = GetDesireTestMethod("https://demoenterprise.gaipp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        Assert.assertEquals("https://demoenterprise.gaipp.com/signn", driver.getCurrentUrl());
        driver.close();
    }

    private static boolean isFirstAttempt = true; // Track if it’s the first attempt
    @Test(retryAnalyzer = RetryAnalyser.class)
    public  void TestCaseFour() {
        if(isFirstAttempt)
        {
            isFirstAttempt =false;
            Assert.fail();
        }
        else
        {
            Assert.assertTrue(true);
        }
    }

    @AfterSuite
    public  void  Closedriver()
    {
        DriverManagerC.removeDriver();
    }

}



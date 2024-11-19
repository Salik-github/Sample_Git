package ABProject;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.sql.DriverManager;


public class ItestListenerClass extends ExtentReportsClass implements ITestListener {

    private  ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    @Override
    public void onStart(ITestContext context) {
        Created();
    }

    @Override
    public void onTestStart(ITestResult result) {
        extentTest.set(extentReports.createTest(result.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
            extentTest.get().log(Status.PASS, result.getName() + " - This Test was passed  ");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver =   DriverManagerC.getDriver();
        ExtentTest test = extentTest.get();
        test.log(Status.FAIL, result.getName() + " - This Test Failed");
        String scrrrenpath  = ScreenShot.takeScreenshot(driver, result.getMethod().getMethodName());
        test.addScreenCaptureFromPath(scrrrenpath);

    }


    @Override
    public void onTestSkipped(ITestResult result) {

        if (result.wasRetried()) {
            System.out.println(result.getName() + " was retried and failed again.");
            extentTest.get().log(Status.FAIL, result.getName() + " - This Test Ultimately Failed");
        } else {
            extentTest.get().log(Status.SKIP, result.getName() + " - This Test Skipped");
            System.out.println(result.getName() + " was skipped.");
        }
    }
    @Override
    public void onFinish(ITestContext context) {
        CloseFlush();
        SendEmailClass oc = new SendEmailClass();
        try {
            System.out.println("Email send ");
            oc.ExtentReportSendViaEmail();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

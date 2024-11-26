package projects.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static utils.FilePath.ReportsFile;

public class ExtentReport implements ITestListener {
    private ExtentReports reports;
    private final ThreadLocal<ExtentTest> test = new ThreadLocal<>(); // Thread-safe for parallel execution

    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(ReportsFile);
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setDocumentTitle("Automation Test Report");
        extentSparkReporter.config().setReportName("Test Results");
        reports = new ExtentReports();
        reports.attachReporter(extentSparkReporter);
        reports.setSystemInfo("Tester", "Mohammed Salik");
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Create a test and assign it to the ThreadLocal variable
        ExtentTest extentTest = reports.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
        if (result.getThrowable() != null) {
            test.get().log(Status.SKIP, result.getThrowable());
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
        if (result.getThrowable() != null) {
            test.get().log(Status.FAIL, result.getThrowable());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        reports.flush();
    }
}

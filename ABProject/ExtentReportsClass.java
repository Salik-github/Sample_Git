package ABProject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import static ABProject.Utils.ExtentReportFile;

public class ExtentReportsClass {
     ExtentReports extentReports;
     ExtentSparkReporter extentSparkReporter;
      ///this commentments  



    public void Created() {
            extentSparkReporter = new ExtentSparkReporter(ExtentReportFile);
            extentSparkReporter.config().setTheme(Theme.STANDARD);
            extentSparkReporter.config().setDocumentTitle("Automation Test Report");
            extentSparkReporter.config().setReportName("Test Results");

            extentReports = new ExtentReports();
            extentReports.attachReporter(extentSparkReporter);
            extentReports.setSystemInfo("Tester", "Mohammed Salik");
            System.out.println("Extent Report Method called ");

    }
    @AfterSuite
    public void CloseFlush() {
        extentReports.flush();
        System.out.println("this is called");
    }
}

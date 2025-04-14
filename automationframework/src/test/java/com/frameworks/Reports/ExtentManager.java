package com.frameworks.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.frameworks.constants.FrameworkConstants;

public class ExtentManager {
    
private static ExtentReports extentReports ;

public static ExtentReports getInstance()
{
    if(extentReports ==null)
    {
        String reports = FrameworkConstants.REPORT_LOCATION;
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reports);
        sparkReporter.config().setDocumentTitle("CMS test Excutions");
        sparkReporter.config().setReportName("Salik test Reports");

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Tester", "Salik");

    }
    return extentReports;
}
}

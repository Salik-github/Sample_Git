package com.frameworks.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.frameworks.Reports.ExtentManager;

public class TestListener implements ITestListener {
    
    private static ExtentReports  extentReports = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result)
    {
        ExtentTest  extentTest = extentReports.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }
    @Override
    public void onTestSuccess(ITestResult result)
    {
        test.get().pass("Test Passed");
    }
    @Override
    public void onTestFailure(ITestResult result)
    {
        test.get().fail(result.getThrowable());
    }
    @Override
    public void onTestSkipped(ITestResult result)
    {
        test.get().skip("Test Skipped" + result.getThrowable());
    }
    @Override
    public void onFinish(ITestContext context)
    {
        extentReports.flush();
    }
}

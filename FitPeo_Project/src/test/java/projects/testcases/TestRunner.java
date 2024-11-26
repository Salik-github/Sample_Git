package projects.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import projects.Reports.ExtentReport;


@Listeners(ExtentReport.class)
public class TestRunner extends BaseTest {

    @Test
    public void calculateRevenuePerMonth() {

        HomePageObject.ClickingAndVerifyTheRevenuePage();
        RevenuePageObject.ScrollDownToMethod();
        RevenuePageObject.checkPatientsCount();
        RevenuePageObject.collectLengthOfCPTValue();
        RevenuePageObject.revenueCalculate();
    }

}

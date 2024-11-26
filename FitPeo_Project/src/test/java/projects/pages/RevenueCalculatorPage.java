package projects.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utils.GetProperty;

import java.util.List;

import static utils.GetProperty.GetArrayDataFromPropertiesFile;
import static utils.GetProperty.GetDataFromPropertiesFile;

public class RevenueCalculatorPage extends BasePage {
    private final By sliderHeader = By.xpath("//h5[text()='Total Gross Revenue Per Year']");
    private final By slider = By.cssSelector("//input[@type='range']");
    private final By Patients = By.id(":r0:");
    private final By allAmountXpath = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 inter css-12bch19']");
    private  final  By GrossRevenueXpath = By.xpath("//h3[contains(@class,'MuiTypography-root MuiTypography-h3')]");

    public RevenueCalculatorPage(WebDriver driver) {

        super(driver);
    }

    public void ScrollDownToMethod() {
        scrollDownToParticularElement(sliderHeader);
        selectSlider();
    }

    public void selectSlider()  {
        try {
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, 0);");
            WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
            WebElement patinest = driver.findElement(Patients);

            // Calculate the offset

            Point location = slider.getLocation();

            // Get the x and y coordinates
            int x = location.getX();
            int y = location.getY();

            // Drag the slider
            Actions actions = new Actions(driver);

            actions.moveByOffset(x + 103, y).click().perform();
            Thread.sleep(3000);
        }
        catch (Exception E)
        {
            System.out.println(E);
        }


    }

    public  void checkPatientsCount()  {
        ManualEnterThePatientsCount("SecondValue");
        ManualEnterThePatientsCount("FirstValue");

    }

    public void ManualEnterThePatientsCount(String patientscount )  {
        WebElement patinest = driver.findElement(Patients);
        try {
            Actions actions = new Actions(driver);
            Thread.sleep(3000);

            actions.click(patinest)
                    .sendKeys("8")
                    .sendKeys(Keys.BACK_SPACE)
                    .sendKeys(Keys.BACK_SPACE)
                    .sendKeys(Keys.BACK_SPACE)
                    .sendKeys(Keys.BACK_SPACE)
                    .sendKeys(GetProperty.GetDataFromPropertiesFile(patientscount))
                    //   .sendKeys(Keys.TAB) // Optionally, simulate pressing Tab to move out of the text box
                    .perform();
            patinest.click();

            checkAttributeAreSame(patientscount);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
    public void checkAttributeAreSame(String patientsCount )
    {
        WebElement patinest = driver.findElement(Patients);
        String a  = patinest.getAttribute("value");
        Assert.assertEquals(a,GetProperty.GetDataFromPropertiesFile(patientsCount));
        System.out.println(a);

    }

    /**
     * Calculate the lenght of the CPT value
     */
    public void collectLengthOfCPTValue() {
        int TotalCPTCheckBoxAvailable = 14;
        String[] CPTData = GetArrayDataFromPropertiesFile("myArray");
        if (CPTData.length < TotalCPTCheckBoxAvailable) {
            for (String CPTValue : CPTData) {

                ClickCPTCheckBox(CPTValue);
            }
        } else {
            System.out.println("Your CPT Data Count above than Available so Change the CPT DATA");
            Assert.fail();
        }
    }

    public void ClickCPTCheckBox(String CPTValue) {

        By CPTCheckBoxXpath = By.xpath("//p[text()='" + CPTValue + "']//parent::div//label//input");
        clickButton(CPTCheckBoxXpath);

    }

    public void revenueCalculate() {

        List<WebElement> e = driver.findElements(allAmountXpath);
        WebElement GrossRevenueElement  = driver.findElement(GrossRevenueXpath);

        String  totalRecurringPatientsPerMonth ;
        double totalGrossRevenuePerYear ;
        double OnetimeReimbursement;
        int patientsCount;
        double onePatientOnetimeReimbursement = 19.19;




        patientsCount  = Integer.parseInt(GetDataFromPropertiesFile("FirstValue"));

        /*
          Calculate the patients per month revenue
         */
        OnetimeReimbursement   = patientsCount * onePatientOnetimeReimbursement;
        totalRecurringPatientsPerMonth = e.get(2).getText().replace("$","");
        System.out.println(totalRecurringPatientsPerMonth);
        String r =GetDataFromPropertiesFile("TotalRecurringReimbursementForAllPatientsPerMonth");
        Assert.assertEquals(totalRecurringPatientsPerMonth,r);

         /*
          Calculate the patients per year revenue
         */
        String totalYearActual = GrossRevenueElement.getText().replace("$","");
        totalGrossRevenuePerYear =(Integer.parseInt(totalRecurringPatientsPerMonth)*12)+OnetimeReimbursement;

        System.out.println("totalRecurringPatientsPerMonth" + totalRecurringPatientsPerMonth);

        System.out.println(totalGrossRevenuePerYear);

    }


}

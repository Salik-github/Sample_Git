package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class classroompage extends basepage{
    
    public classroompage(WebDriver driver)
    {
        super(driver);
    }
   // private final By livesessionBy = By.xpath("//a[text()='Live Sessions']");
    private final By livesessionBy = By.cssSelector("a[href='#livesessions']");
    private final By ScheduleBy = By.xpath("//button[contains(@class,'mt-2 mt-sm-0 v-btn v-btn-')]");
    private final By AddSess = By.xpath("//span[text()='Add session ']");
   // private final By timeBy = By.id("input-641");
    private final By timeBy = By.cssSelector("div[class='v-select__slot']");
    private final By createBy = By.xpath("//span[text()=' Create ']");
    private final By timeLineBy = By.xpath("//a[text()='Timeline']");
    private final By listnerBy = By.xpath("//div[@class='text--18 font-weight--600 mb-2']");
    private final By status  = By.cssSelector(".v-chip__content");
    private final By sisname = By.xpath("//div[text()='Live session']");
    private final By timeBy2  = By.cssSelector("div[class='text--12 greySecondary--text text-no-wrap']");
    private final By pm = By.cssSelector("div[class='text--16']");
    
    
    public   void clickandScheduleSession()
    {
        WebElement liveSessionHeader = driver.findElement(livesessionBy);
        clickElement(liveSessionHeader);

        
        WebElement scheduleSession = driver.findElement(ScheduleBy);
        waitElement(ScheduleBy);
        clickElement(scheduleSession);

        WebElement addsession = driver.findElement(AddSess);
        waitElement(AddSess);
        clickElement(addsession);

        WebElement timeInput = driver.findElement(By.cssSelector("input[id*='input-']"));

        // Click the field to activate it
       // timeInput.click();

        // Clear existing value
        timeInput.clear();

        // Enter the new time value (10:00)
        timeInput.sendKeys("10:00");


        // List<WebElement> setTiming = driver.findElements(timeBy);
        // setTiming.get(3).click();
        // setTiming.get(3).clear();
        // sendValue( setTiming.get(3), getproperty.GetDataFromPropertyFile("time"));

        WebElement AMtoPM= driver.findElement(pm);
        AMtoPM.click();

        WebElement create = driver.findElement(createBy);
        clickElement(create);

    }
    public void verifySession()
    {
        WebElement timeline = driver.findElement(timeLineBy);
        timeline.click();
        
        WebElement listenerName = driver.findElement(listnerBy);
        waitElement(listnerBy);
        isDisplay(listenerName);

        WebElement upcomingStatus  = driver.findElement(status);
        isDisplay(upcomingStatus);

        
        WebElement sessionName  = driver.findElement(sisname);
        isDisplay(sessionName);

        WebElement sessionTime  = driver.findElement(timeBy2);
        isDisplay(sessionTime);

        
        
    }
    public void isDisplay(WebElement element){
       Assert.assertTrue(element.isDisplayed());
    }


    
}

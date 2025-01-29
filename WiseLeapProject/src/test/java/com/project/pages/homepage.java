package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class homepage extends basepage {

    public homepage(WebDriver driver) {
        super(driver);
    }

    private final By Group = By.xpath("//span[text()='Group courses ']");
    private final By nameby = By.xpath("//a[contains(text(),'Classroom for Automated testing')]");
    private final By classHeading = By.xpath("//div[@class='text--24 font-weight--600']");

    public void GoToTheClassroom() {
        clickgroupCourse();
        clickclassroom();
        verifyclassHeadingVisible();
    }

    private void clickgroupCourse() {
        WebElement groupCourse = driver.findElement(Group);
        clickElement(groupCourse);
    }

    private void clickclassroom() {
        WebElement className = driver.findElement(nameby);
        clickElement(className);
    }

    private void verifyclassHeadingVisible()

    {
        WebElement checkvisible = driver.findElement(classHeading);
        Assert.assertTrue(checkvisible.isDisplayed(), "Classroom is opened Successfully");
    }

}

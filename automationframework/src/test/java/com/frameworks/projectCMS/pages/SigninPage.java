package com.frameworks.projectCMS.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.fasterxml.jackson.databind.JsonNode;
import com.frameworks.constants.FrameworkConstants;
import com.frameworks.drivers.DriverManager;
import com.frameworks.helpers.JsonHelper;
import com.frameworks.helpers.SystemHelper;
import static com.frameworks.keywords.WebUI.checkMessageDisplay;
import static com.frameworks.keywords.WebUI.clickMethod;
import static com.frameworks.keywords.WebUI.enterData;

public class SigninPage {
    WebDriver driver;

    public SigninPage(WebDriver driver) {
        this.driver = driver;
    }

    public By inputEmail = By.id("email");
    public By inputPassword = By.id("password");
    public By signInButton = By.xpath("//button[text()='Sign in']");
    public By linkSignup = By.xpath("//a[text()='Sign up']");
    public By forgotPass = By.xpath("//a[text()='Forgot password?']");
    public By alertMessage = By.xpath("//div[@class='alert alert-danger']");

    public void enterEmail(String email) {
        enterData(inputEmail, email);
    }

    public void enterpassword(String password) {
        enterData(inputPassword, password);
    }

    public void clickSignin() {
        clickMethod(signInButton);
    }

    public void clickSignup() {
        clickMethod(linkSignup);
    }

    public void clickForgotPassword() {
        clickMethod(forgotPass);
    }

    public void validDataSignin() {
        enterEmail(null);
    }

    public void checkAlertDisplay() {
        checkMessageDisplay(alertMessage);
    }

    JsonNode user = JsonHelper.readUserFromFile();

    public void validDataLogin() {
        enterEmail(user.get("email").asText());
        enterpassword(user.get("password").asText());
        clickSignin();
        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(), FrameworkConstants.DASHBOARD_URL);
    }
    // Remember me

    public void invalidEmail() {
        enterEmail(FrameworkConstants.INVALID_EMAIL);
        enterpassword(FrameworkConstants.INVALID_PASSWORD);
        clickSignin();
        checkAlertDisplay();

    }

    public void navigateToforgotPassword() {
        clickForgotPassword();
        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(), FrameworkConstants.FORGOT_PASSWORD_URL);
    }

    public void calculateLoginTime() {
        long startTime = SystemHelper.getCurrentTimeMillies();
        validDataLogin();
        long endTime = SystemHelper.getCurrentTimeMillies();
        Assert.assertTrue(endTime - startTime < 3000);
    }

}

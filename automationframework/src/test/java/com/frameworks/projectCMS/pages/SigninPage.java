package com.frameworks.projectCMS.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.frameworks.helpers.JsonHelper;

import static com.frameworks.keywords.WebUI.*;


public class SigninPage {
    WebDriver driver;
    public SigninPage(WebDriver driver)
    {
        this.driver = driver;
    }

        public By inputEmail = By.id("email");
        public By inputPassword = By.id("password");
        public By signInButton = By.xpath("//button[text()='Sign in']");
        public By linkSignup=By.xpath("//a[text()='Sign up']");
        public By forgotPass = By.xpath("//a[text()='Forgot password?']");

        public void enterEmail(String email) {
            enterData(inputEmail, email);
        }
        public void enterpassword(String password) {
            enterData(inputPassword, password);
        }
        public void clickSignin()
        {
            clickMethod(signInButton);
        }
        public void clickSignup()
        {
            clickMethod(linkSignup);
        }
        public void clickForgotPassword()
        {
            clickMethod(forgotPass);
        }
        public void validDataSignin()
        {
            enterEmail(null);
        }
        JsonNode user = JsonHelper.readUserFromFile();
        public void validDataLogin()
        {
            enterEmail(user.get("email").asText());
            enterpassword(user.get("password").asText());
            clickSignin();
        }
        //Remember me  
    

}

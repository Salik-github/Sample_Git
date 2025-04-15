package com.frameworks.projectCMS.testcases;

import org.testng.annotations.Test;

import com.frameworks.common.BaseTest;
import com.frameworks.drivers.DriverManager;
import com.frameworks.projectCMS.pages.SigninPage;

public class SigninTest extends BaseTest{
    
    @Test (priority = 1, description = "Valid data with login successfull")
    public void testSuccessfulllogin()
    {
        SigninPage signinPage = new SigninPage(DriverManager.getDriver());
        signinPage.validDataLogin();
        //signinPage.
    }
    @Test (priority= 2 , description= "Login with invalid email")
    public void testWithInvalidEmail()
    {
        SigninPage signinPage = new SigninPage(DriverManager.getDriver());
        signinPage.invalidEmail();
    }
    @Test(priority = 3 , description = "navigate to forgotpassword page")
    public  void navigateToforgotPasswordPage()
    {
        SigninPage signinPage = new SigninPage(DriverManager.getDriver());
        signinPage.navigateToforgotPassword();
    }
    @Test (priority=4 , description = "Check Login loading time ")
    public  void checkLoginLoadTime()
    {
        SigninPage signinPage = new SigninPage(DriverManager.getDriver());
        signinPage.calculateLoginTime();
    }
}

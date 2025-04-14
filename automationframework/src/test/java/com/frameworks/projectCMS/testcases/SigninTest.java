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
}

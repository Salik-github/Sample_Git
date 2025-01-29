package com.project.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.project.pages.homepage;
import com.project.pages.login;

public class testSuite extends basetest {
    
    login loginobj ; 
    homepage homepageobj;
    @BeforeTest
    public void createObj()
    {
         loginobj = new login(driver);
         homepageobj =new homepage(driver);

    }
    @Test
    
    public void loginWithMobileNumber()
    {
        loginobj.clickContinueWithMobile();
        loginobj.testLoginWithPhoneNumberAndOTP() ;
        homepageobj.GoToTheClassroom();
    }
}

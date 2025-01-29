package com.project.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.project.pages.classroompage;
import com.project.pages.homepage;
import com.project.pages.login;

public class testSuite extends basetest {
    
    login loginobj ; 
    homepage homepageobj;
    classroompage classroompageobj;
    @BeforeTest
    public void createObj()
    {
         loginobj = new login(driver);
         homepageobj =new homepage(driver);
         classroompageobj = new classroompage(driver);

    }
    @Test
    
    public void loginWithMobileNumber()
    {
        loginobj.performLoginAsATutor();
        homepageobj.GoToTheClassroom();
        classroompageobj.clickandScheduleSession();
        classroompageobj.verifySession();

    }
}

package com.frameworks.projectCMS.testcases;

import org.testng.annotations.Test;

import static com.frameworks.helpers.TestDataHelper.*;

import com.frameworks.common.BaseTest;
import com.frameworks.drivers.DriverManager;
import com.frameworks.helpers.pojoForSignupdata;
import com.frameworks.projectCMS.pages.SignupPage;

public class SignupTest extends BaseTest {

    private static String individual = "individual";

    private static String oraganization = "organization";

    @Test(priority = 1, description = "verify successfull signup as Individual")
    public void testSuccessfulIndividual() {

        pojoForSignupdata user = new pojoForSignupdata(getFirstName(), getLastName(), individual, getEmail(),
                getPassword());
        SignupPage signupObj = new SignupPage(DriverManager.getDriver());

        signupObj.successfullInindividual(user);
    }
    @Test(priority = 2, description = "verify successfull signup as Organization")
    public void testSuccessfulOrganization()
    {
        pojoForSignupdata user = new pojoForSignupdata(getFirstName(), getLastName(), oraganization,getCompanyName(), getEmail(),
        getPassword());
        SignupPage signupObj = new SignupPage(DriverManager.getDriver());

        signupObj.successfullOrganization(user);
    }
    // Password match validation 
    // required Field validation 
    // invalid email format 
    // testWeakPasswordValidation
    @Test (priority = 3, description = "Varify navigation to sigin page")
    public void testNavigaionTosigninPage()
    {
        SignupPage signupObj = new SignupPage(DriverManager.getDriver());

        signupObj.navigateToSignIn();
    }
    
}

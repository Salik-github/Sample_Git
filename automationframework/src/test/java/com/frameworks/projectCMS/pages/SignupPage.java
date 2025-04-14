package com.frameworks.projectCMS.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.frameworks.keywords.WebUI.*;

import com.frameworks.helpers.JsonHelper;
import com.frameworks.helpers.pojoForSignupdata;

public class SignupPage {

    private WebDriver driver;
    pojoForSignupdata pojoObj;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        pojoObj = new pojoForSignupdata();
    }

    private String SignupPageUrl = "/signup";
    private String SigninPageUrl = "/signin";

    public static String SignupTitle = "    Sign up | RISE CRM | Anh Tester Demo";
    public By inputFirstname = By.id("first_name");
    public By inputLastname = By.id("last_name");
    public By radioOrg = By.id("type_organization");
    public By inputCompanyName = By.id("company_name");
    public By inputEmail = By.id("email");
    public By inputPassword = By.id("password");
    public By inputRePassword = By.id("retype_password");
    public By radioInd = By.id("type_person");
    public By linksignup = By.xpath("//button[text()='Sign up']");
    public By LinksignIn = By.xpath("//a[text()='Sign in']");
    public By signupsuccessMessage = By.xpath("//div[text()='Your account has been created successfully! ']");

    public void enterFirstName(String firstname) {
        enterData(inputFirstname, firstname);
    }

    public void enterLastName(String lastname) {
        enterData(inputLastname, lastname);
    }

    public void selecttype(String type) {
        if (type.equalsIgnoreCase("organization")) {
            clickMethod(radioOrg);
        } else {
            System.out.println("this");
            clickMethod(radioInd);
        }
    }
    public void enterCompanyName(String companyName)
    {
        enterData(inputCompanyName, companyName);
    }

    public void enterEmail(String email) {
        enterData(inputEmail, email);
    }

    public void enterpassword(String password) {
        enterData(inputPassword, password);
    }

    public void enterRepassword(String repassword) {
        enterData(inputRePassword, repassword);
    }

    public void clickSingup() {
        ScroltoElement(linksignup);
        clickMethod(linksignup);
    }

    public void clickSignin() {
        ScroltoElement(LinksignIn);
        clickMethod(LinksignIn);
    }

    public boolean isSignupSuccessfull() {

        checkMessageDisplay(signupsuccessMessage);
        WebElement e = BytoWebElement_forEnterData(signupsuccessMessage);
        return e.isDisplayed();
    }

    public void successfullInindividual(pojoForSignupdata user) {
        enterFirstName(user.getFirstname());
        enterLastName(user.getLastname());
        selecttype(user.getUsertype());

        enterEmail(user.getEmail());
        enterpassword(user.getPassword());
        enterRepassword(user.getPassword());
        clickSingup();

        Assert.assertTrue(isSignupSuccessfull(), "Message not display");
        JsonHelper.writeUsertoFile(user);

    }
    public void successfullOrganization(pojoForSignupdata user) {
        enterFirstName(user.getFirstname());
        enterLastName(user.getLastname());
        selecttype(user.getUsertype());
        enterCompanyName(user.getCompany_name());
        enterEmail(user.getEmail());
        enterpassword(user.getPassword());
        ScroltoElement(linksignup);
        enterRepassword(user.getPassword());
        clickSingup();

        Assert.assertTrue(isSignupSuccessfull(), "Message not display");
    }
    public void navigateToSignIn()
    {
        clickSignin();
        waitForURL(SigninPageUrl);

    }

}

package website.TestClass;

import java.util.Random;
import org.testng.annotations.Test;
import website.PageClass.TestCase1Page;

//Register User
public class TestCase1 extends Utilis {
    TestCase1Page oc ;
    @Test(priority = 0)//C:\Users\MY-PC\SalikVs\automate\src\test\java\website\PageClass\PageTestCase1.java
    public void Register_User()
    {
        oc = new TestCase1Page(driver);
        oc.ClickingSignupHomeButton_WithVerifyHeading();
        oc.EnterNewName("Salik");
        Random n = new Random();
        int n1 = n.nextInt(100);    
        oc.EnterEmail("Mohammed"+n1+"sa@gmail.com", "New");
        oc.ClickingSignupButton();
       
    }
    @Test(priority = 1)
    public void Enter_User_Details()
    {
        oc.ClickingRediobuttonforTitle("Mr");
        oc.SetPassword();
        oc.SelectingDOB("20", "January","2003");
        oc.ClickingRediobuttonforDeclare(0);
        oc. User_Information();
        oc.ClickingCreatedAccountButton();
        oc.DeletedAccount();
    }
    
}

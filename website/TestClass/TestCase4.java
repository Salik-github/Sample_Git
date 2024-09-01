package website.TestClass;


import org.testng.annotations.Test;

import website.PageClass.TestCase2Page;
import website.PageClass.TestCase4Page;

public class TestCase4 extends Utilis {
 
    TestCase4Page oc;
    TestCase2Page nc;
    
    @Test
    public void UserLogin_Logged()
    {
         oc  = new TestCase4Page(driver);
        // nc = new TestCase2Page(driver);
         oc.LoginWithExitingAccount();
         oc.LogoutAccount();

    }
}

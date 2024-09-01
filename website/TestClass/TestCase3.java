package website.TestClass;


import org.testng.annotations.Test;

import website.PageClass.TestCase2Page;
import website.PageClass.TestCase3Page;

public class TestCase3 extends Utilis{

    TestCase2Page oc ;
    TestCase3Page nc ;
    @Test
    public void TestForInvalidUserName_Password()
    {
        nc = new TestCase3Page(driver);
        oc = new TestCase2Page(driver);
        oc.ClickingSignupHomeButton_ForOldUser();
        nc.InvalidEmailEnter();
    }
       
    
}
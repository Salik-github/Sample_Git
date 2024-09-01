package website.TestClass;

import org.testng.annotations.Test;

import website.PageClass.TestCase4Page;

public class TestCase5 extends Utilis {

    TestCase4Page oc;
    @Test
    public void LoginWithExitingEmail()
    {
         oc  = new TestCase4Page(driver);
        oc. LoggingWithExitingEmail();
    }
    
}

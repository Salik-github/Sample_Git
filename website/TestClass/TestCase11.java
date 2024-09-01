package website.TestClass;

import org.testng.annotations.Test;

import website.PageClass.TestCase10Page;
import website.PageClass.TestCase11Page;

public class TestCase11 extends Utilis {
    
    @Test
    public void Verify_Subcription()
    {
        TestCase11Page oc =  new TestCase11Page(driver);
        TestCase10Page nc = new TestCase10Page(driver);
        oc.CartPageVerify();
        nc.EnterEmailforSubcription();
    }
}

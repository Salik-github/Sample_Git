package website.TestClass;

import org.testng.annotations.Test;
import website.PageClass.TestCase7Page;

public class TestCase7 extends Utilis {
    
    @Test
    public void VerifyUserNevigate_to_TestCase_Page()
    {
     TestCase7Page oc = new TestCase7Page(driver); 
     oc.VerifyTestCasePage_Opened();
    }
}

package website.TestClass;

import org.testng.annotations.Test;

import website.PageClass.TestCase10Page;

public class TestCase10 extends Utilis {
    
    @Test
    public void Subcription()
    {
        TestCase10Page oc = new TestCase10Page(driver);
        
        oc.EnterEmailforSubcription();
    }
}

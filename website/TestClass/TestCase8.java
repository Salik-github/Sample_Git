package website.TestClass;

import org.testng.annotations.Test;

import website.PageClass.TestCase8Page;

public class TestCase8 extends Utilis {
    
    @Test
    public void Verify_All_product_page()
    {
        TestCase8Page oc =  new TestCase8Page(driver);
        oc.Verify_Product();
    }
}

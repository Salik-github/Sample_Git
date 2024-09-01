package website.TestClass;

import org.testng.annotations.Test;

import website.PageClass.TestCase8Page;
import website.PageClass.TestCase9Page;

public class TestCase9 extends Utilis{
    @Test
    public void Search_Product()
    {
        TestCase9Page oc = new TestCase9Page(driver);
        TestCase8Page nc = new TestCase8Page(driver);
        nc.ClickingProductButton();
        oc.SearchingProduct();
        
    }
}

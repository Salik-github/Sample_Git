package website.TestClass;

import org.testng.annotations.Test;

import website.PageClass.TestCase6Page;

public class TestCase6 extends Utilis{

    TestCase6Page oc ;
    @Test
    public void Contact_Us_Form()
    {
        oc = new TestCase6Page(driver);
        oc.ContactTestCase();
        oc.AfterContactFormSubmit();

    }
    //C:\Users\MY-PC\SalikVs\automate\src\test\java\website
}

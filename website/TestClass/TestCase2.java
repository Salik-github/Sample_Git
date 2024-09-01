package website.TestClass;


import org.testng.annotations.Test;

import website.PageClass.CommonPageMethod;
import website.PageClass.TestCase1Page;

public class TestCase2 extends Utilis {
    TestCase1Page oc;
    CommonPageMethod nc;
   

    String email ="asff@gmail.com";
    @Test
    public  void SignupTestCase()
    {
        oc = new TestCase1Page(driver);
        nc =new CommonPageMethod(driver);
        nc.ClickingSignupHomeButton_ForOldUser();  
        oc.EnterEmail(email, "Old");
        nc.EnterPassword();
        nc.ClickingLoginButton();
        oc.verifyLogged();
        oc.DeletedAccount();
       
    }

}

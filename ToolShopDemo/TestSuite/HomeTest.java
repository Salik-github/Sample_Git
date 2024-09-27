package ToolShopDemo.TestSuite;
import org.testng.annotations.Test;
import ToolShopDemo.WebsitePage.PageFunction.HomePageAction;
import ToolShopDemo.WebsitePage.PageFunction.SigninPageAction;

public class HomeTest extends UtilsTest {

   

    @Test
    public void TestCaseOne() {
        HomePageAction homePageObject = new HomePageAction(driver);
        homePageObject.VerifyHomePageLanded();
        SigninPageAction sp = new SigninPageAction(driver);
        sp.EnterEmail("djihvbnr");
        sp.EnterPassword("12345");
    }
    @Test
    public void VerfiySortFilter() 
    { 
        HomePageAction HPA = new HomePageAction(driver);
        HPA.VerifyHomePageLanded();
        HPA.CheckSortFilter();
        HPA.CheckingSortingItem();
    }
}   

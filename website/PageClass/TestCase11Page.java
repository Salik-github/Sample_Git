package website.PageClass;

import org.openqa.selenium.WebDriver;

public class TestCase11Page extends CommonPageMethod {
    
    public TestCase11Page (WebDriver driver)
    {
        super(driver);
    }

    public void CartPageVerify()
    {
        ClickingCardButton();
    }
}

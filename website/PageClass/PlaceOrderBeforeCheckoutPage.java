package website.PageClass;

import org.openqa.selenium.WebDriver;

public class PlaceOrderBeforeCheckoutPage extends PlaceOrderRegisterwithCheckoutPage{

    public PlaceOrderBeforeCheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void Register()
    {
        ClickingSignupHomeButton_WithVerifyHeading();
        InSignupPageName_Email();
        EnterUserDetailsCommon();

    }
    public void Product_AddTo_Cart_AfterLogin()
    {
        ProductAddtoCartFlow();
        PrintTotalAmount();
        ClickingButtonMethod(driver.findElement(Placeorder));
        PaymentPageFields();
        VerfiyOrderSucces();
        DeletedAccount();
    }
    

}

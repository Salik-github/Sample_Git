package website.TestClass;

import org.testng.annotations.Test;

import website.PageClass.PlaceOrderBeforeCheckoutPage;
import website.PageClass.PlaceOrderRegisterwithCheckoutPage;
import website.PageClass.ProductQuantityinCartPage;
import website.PageClass.RemoveproductfromcartPage;

public class TestCase13_to_18 extends Utilis {
    

    @Test
    public void Verify_Product_quantity_in_Cart()
    {
        ProductQuantityinCartPage oc = new ProductQuantityinCartPage(driver);
        oc.View_Product_Add_to_Cart();
    }
    @Test
    public void Place_Order_Register_with_Checkout ()
    {  
        PlaceOrderRegisterwithCheckoutPage oc= new PlaceOrderRegisterwithCheckoutPage(driver);
        oc.ProductAddtoCartFlow();
        oc. SignupFromCart();
        oc. AfterLoggedCheckout();

    }
    @Test
    public void Place_Order_Register_before_Checkout()
    {
        PlaceOrderBeforeCheckoutPage oc  = new PlaceOrderBeforeCheckoutPage(driver);
        oc.Register();
        oc.Product_AddTo_Cart_AfterLogin();
    }
    @Test
    public void Remove_Product_From_Cart()
    {
        RemoveproductfromcartPage oc = new RemoveproductfromcartPage(driver);
        oc.RemoveProductCart();

    }
}

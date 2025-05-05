import BasePage  from "./basePage";
import { add_to_cart_Button,cardBadge,backPackAddToCartBtn } from "../pageObjects/productPage";

export default class productPage extends BasePage
{
    constructor (page)
    {
        super(page);
    }
    async verifyCardIconVisible(cart_icon)
    {
        await this.verifyitsVisible(cart_icon)
    }
    async verifyLenghtOfElement(locator , size)
    {
       var count =  await this .verifyElementSize(locator)
       await this.expectMethod(count,size);
    }
    async check_Add_to_Cart_and_Count()
    {
        // for(let i=0;i<4;i++)
        // {

            await this.waitForPageLoad();
            await this.clickMethod(backPackAddToCartBtn);
           await this.expectMethod (await this.verifyTextisVisible(cardBadge),1);
       // }
    }
}
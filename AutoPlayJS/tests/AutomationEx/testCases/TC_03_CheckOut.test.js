import { expect } from "@playwright/test";
import test from '../testFixtures/fixture'
import{checkoutstep2,checkoutstep3,dashboardURL}from '../../../config';
require('dotenv').config();
import { username, password } from "../pageObjects/loginPage";
import { backPackAddToCartBtn, bikeLightAddToCartBtn, bolt_tshirtAddToCartBtn, cart_icon, bikeLightRemoveBtn } from "../pageObjects/productPage";
import { firstname,lastname,postalCode,continueBtn ,finish,complete,backtoHome} from "../pageObjects/checkoutPage";

test.describe('Checkout Functionalities', () => {
    test.beforeEach('Login functions', async ({ LoginPage, basePage }) => {
        await LoginPage.openURL();
        await basePage.LoginFunctions(username, password, process.env.USERNAME1, process.env.PASSWORD);
    })
    test('checkout process testcases', async ({ productPage, basePage, checkoutPage }) => {
        await test.step('product add to the cart and verify Cart count ', async () => {
            await productPage.add_to_cart_product(backPackAddToCartBtn);
            await productPage.add_to_cart_product(bikeLightAddToCartBtn);
            await productPage.add_to_cart_product(bolt_tshirtAddToCartBtn);
            await productPage.verifycount("3");
        })
        await test.step('redirect to the checkout Page and remove one item ', async () => {
            await basePage.clickMethod(cart_icon)
            await productPage.check_Remove_to_Cart_and_Count(bikeLightRemoveBtn, "2");
            await checkoutPage.click_checkoutPage();
            await basePage.verifyUrl(checkoutstep2)

        })
        await test.step('fill user data into the checkout page ',async()=>{
            await checkoutPage.enterUserDetails(firstname,process.env.USERFIRST)
            await checkoutPage.enterUserDetails(lastname,process.env.USERLAST)
            await checkoutPage.enterUserDetails(postalCode,process.env.POSTAL_CODE)
            await basePage.clickMethod(continueBtn)
            await basePage.verifyUrl(checkoutstep3);
            await basePage.clickMethod(finish);
            await basePage.verifyitsVisible(complete);
            await basePage.clickMethod(backtoHome);
            await basePage.verifyUrl(dashboardURL);
        })
    })
})
import { expert } from '@playwright/test';

import test from '../testFixtures/fixture';
import LoginPage from '../pages/loginPage';
import productPage from '../pages/productPage';
require('dotenv').config();
import { username, password, } from '../pageObjects/loginPage';
import {
    cart_icon, filter, values, side_Menu_icon,
    All_Items, About, logout, Reset, Card, product_name, product_des,
    product_price, add_to_cart_Button, product_image, backPackAddToCartBtn, bikeLightAddToCartBtn, bolt_tshirtAddToCartBtn,backPackRemoveBtn
,bikeLightRemoveBtn,bolt_tshirtRemoveBtn} from '../pageObjects/productPage';
/*
Verify All Products are Displayed
Verify Product Name, Description, Price, and Add to Cart Button
Add to Cart Functionality
Product Sorting - Name (A to Z)
Verify Filter Dropdown Options
Verify Product Price Format
Verify Product Image is Displayed
Verify Add to Cart Button Text Changes After Click
Verify Navigation to Product Detail Page (if applicable)
Verify Cart Icon Badge Count Updates
Verify Sorting by Price (Low to High)
Responsive Design Test
Verify Page Title and Header
*/

test.describe(`@SecondTestCase : Verify Product Page `, () => {

    test.beforeEach(async ({ LoginPage, basePage }) => {
        await LoginPage.openURL();
        await basePage.LoginFunctions(username, password, process.env.USERNAME1, process.env.PASSWORD);
    });
   // test('Product Page Functionality and UI checkin ', async ({ LoginPage, productPage }) => {

        //     await test.step ('verify Cart icons are visible',async()=>{
        //         await productPage.verifyCardIconVisible(cart_icon);
        //     })
        //     await test.step ('verify Fitlers are visible',async()=>{
        //         await productPage.verifyCardIconVisible(filter);
        //     })
        //     await test.step ('verify side menu icon are visible',async()=>{
        //         await productPage.verifyCardIconVisible(side_Menu_icon);
        //     })
        //     await test.step ('verify cards count match ',async()=>{
        //         const count  = 6;
        //         await productPage.verifyLenghtOfElement(Card, count);
        //         await productPage.verifyLenghtOfElement(product_name, count);
        //         await productPage.verifyLenghtOfElement(product_des, count);
        //         await productPage.verifyLenghtOfElement(product_price, count);
        //         await productPage.verifyLenghtOfElement(add_to_cart_Button, count);
        //         await productPage.verifyLenghtOfElement(product_image, count);
        //     })
 //   })
    test('Check the product page functionalitys', async ({ LoginPage, productPage }) => {
        // await test.step('Check click add to card ,icon count was increase', async () => {
        //     await productPage.check_Add_to_Cart_and_Count(backPackAddToCartBtn, "1");
        //     await productPage.check_Add_to_Cart_and_Count(bikeLightAddToCartBtn, "2");
        //     await productPage.check_Add_to_Cart_and_Count(bolt_tshirtAddToCartBtn, "3");

        // })
        // // await test.step('Check Fitlers are working', async () => {
        // //     await productPage.verify_filters_sorting(values[1]);
        // //     await productPage.verify_filters_sorting(values[3]);


        // // })
        // await test.step('Check click add to card ,icon count was increase', async () => {
        //     await productPage.check_Remove_to_Cart_and_Count(backPackRemoveBtn, "2");
        //     await productPage.check_Remove_to_Cart_and_Count(bikeLightRemoveBtn, "1");
        //     await productPage.check_Remove_to_Cart_and_Count(bolt_tshirtRemoveBtn, "");

        // })

        await test.step('view describtion checking',async()=>{
            await productPage.checkViewDescribtion(product_name);
        })
    })
    
})

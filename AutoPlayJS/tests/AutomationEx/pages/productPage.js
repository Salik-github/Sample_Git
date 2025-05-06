import BasePage from "./basePage";
import { filter, cart_icon, add_to_cart_Button, cardBadge, backPackAddToCartBtn } from "../pageObjects/productPage";
import { selectors } from "@playwright/test";
import { backpack } from "../../../config";

export default class productPage extends BasePage {
    constructor(page) {
        super(page);
    }
    async verifyCardIconVisible(cart_icon) {
        await this.verifyitsVisible(cart_icon)
    }
    async verifyLenghtOfElement(locator, size) {
        var count = await this.verifyElementSize(locator)
        await this.expectMethod(count, size);
    }
    async verifyElementVisible(selector) {
        await this.checkVisibleElement(selector);
    }
    async check_Add_to_Cart_and_Count(selector, count) {

        await this.clickMethod(selector);
        await this.verifycount(count);
        //await this.expectMethod(await this.getText(cart_icon), count);
    }
    async verifycount(count) {
        await this.expectMethod(await this.getText(cart_icon), count);
    }
    async add_to_cart_product(selector) {
        await this.clickMethod(selector);
    }
    async verify_filters_sorting(values) {
        await this.selectByValue(filter, values)

        // if (values === 'za') {
        //     console.log(values);
        //     await this.compareTwoScreenshot('za.png');
        // }
        // else {
        //     console.log(values);
        //     await this.compareTwoScreenshot('hilo.png');

        // }
        await this.takeScreenShot();
    }
    async check_Remove_to_Cart_and_Count(selector, count) {
        await this.clickMethod(selector);
        await this.verifycount(count);
        // await this.expectMethod(await this.getText(cart_icon), count);
    }
    async checkViewDescribtion(selector) {
        await this.clickMethod(selector);
        await this.verifyUrl(backpack);
    }

}
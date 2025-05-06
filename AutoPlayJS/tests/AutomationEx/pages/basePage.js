import { expect } from '@playwright/test'
import { dashboardURL, screenshotPath } from '../../../config';
import { loginButton } from '../pageObjects/loginPage';


export default class BasePage {
    constructor(page) {
        this.page = page
    }
    async LoginFunctions(locatorUsername, locatorPassword, user, pass) {
        await this.waitAndFill(locatorUsername, user)
        await this.waitAndFill(locatorPassword, pass)
        await this.clickMethod(loginButton)
        await this.verifyUrl(dashboardURL)
    }
    async launchUrl(url) {
        return await this.page.goto(url);
    }
    async getTitle() {
        return await this.page.title();
    }
    async verifyitsVisible(selector) {
        const element = this.page.locator(selector)
        // await this.page.waitForTimeout(4000);
        await expect(element).toBeVisible();
    }
    async getUrl() {
        return await this.page.url()
    }
    async wait() {
        return this.page.waitForTimeout(1000);
    }
    async waitForPageLoad() {
        await this.page.waitForLoadState('domcontentloaded')

        await this.page.waitForTimeout(5000);
    }
    async clickMethod(selector) {
        //  await this.page.waitForSelector(selector, { state: 'visible', timeout: 10000 });
        return await this.page.click(selector);
    }
    async waitAndFill(selector, content) {

        return await this.page.fill(selector, content);
    }
    async keypress(selector, Key) {
        return await this.page.press(selector, Key)
    }
    async clearText(selector) {
        await this.page.press(selector, "Control+A")
        await this.page.press(selector, "Delete")
    }
    async verifyElementText(selector, text) {
        const textvalue = await this.page.textContent(selector)
        return await expect(textvalue.tirm()).toBe(text)
    }
    async verifyElementSize(locator) {
        return await this.page.locator(locator).count();
    }
    async verifyElementContainText(selector, text) {
        const locatortext = await this.page.locator(selector)
        return await expect(locatortext).toContainText(text)
    }
    async expectMethod(actual, expected) {
        await expect(actual).toBe(expected);
    }
    async verifyUrl(url) {
        const currentURL = this.page.url()
        console.log(currentURL);
        await this.page.waitForTimeout(4000)
        return this.expectMethod(currentURL, url)
    }
    async verifyElementEnable(locator, ErrorMessage) {
        const element = this.page.locator(locator);
        try {
            const isEnable = await element.isEnabled();
            expect(isEnable).toBeTruthy();
        } catch (error) {
            throw new Error(`${ErrorMessage}`)
        }
    }
    async verifyTextisVisible(selector) {
        const element = await this.page.getByText(selector, { exact: true });
        expect(element).toBeVisible();
        return element;
    }
    async getText(selector) {
        return await this.page.locator(selector).textContent();
    }
    async selectByValue(selector, values) {
        return await this.page.selectOption(selector, values);
    }
    async checkVisibleElement(selector) {
        return await expect(this.page.locator(selector)).first().toBeVisible();
    }
    async takeScreenShot() {

        return await this.page.screenshot({ path: screenshotPath + 'hilo.png' });
    }
    async compareTwoScreenshot() {
        // const scot =  await this.page.screenshot();
        return await expect(this.page).toHaveScreenshot();
    }

}


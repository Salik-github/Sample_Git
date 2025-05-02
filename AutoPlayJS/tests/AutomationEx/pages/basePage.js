import { expect } from '@playwright/test'

export default class BasePage {
    constructor(page) {
        this.page = page
    }
    async launchUrl(url) {
        return await this.page.goto(url);
    }
    async getTitle()
    {
        return await this.page.title();
    }
    async verifyitsVisible(selector)
    {
        const element  = this.page.locator(selector);
        await expect(element).toBeVisible();
    }
    async getUrl()
    {
        return await this.page.url()
    }
    async wait()
    {
        return  this.page.waitForTimeout(1000);
    }
    async waitForPageLoad ()
    {
        return await this.page.waitForLoadState('domcontentloaded')
    }
    async clickMethod(selector)
    {
        return  await this.page.click(selector);
    }
    async waitAndFill(selector , content)
    {
        return  await this.page.fill(selector,content);
    }
    async  keypress(selector ,Key)
    {
        return await this.page.press(selector ,Key)
    }
    async verifyElementText(selector , text)
    {
        const textvalue = await this.page.textContent(selector)
        return await expect(textvalue.tirm()).toBe(text)
    }
    async verifyElementContainText(selector , text)
    {
        const locatortext = await this.page.locator(selector)
        return await expect(locatortext).toContainText(text)
    }
    async expectMethod(actual , expected)
    {
        await expect(actual).toBe(expected);
    }
    async verifyUrl(url)
    {
    const currentURL = this.getUrl()
    return this.expectMethod(currentURL,url)
    }
    async verifyElementEnable(locator,ErrorMessage)
    {
        const element = this.page.locator(locator);
        try{
            const isEnable = await element.isEnabled();
            expect(isEnable).toBeTruthy();
        }catch(error)    
        {
            throw new Error(`${ErrorMessage}`)
        }
    }

}

 
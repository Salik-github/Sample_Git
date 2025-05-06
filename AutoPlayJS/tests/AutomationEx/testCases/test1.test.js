import { test, expert } from '@playwright/test';

const backPackAddToCartBtn = '#add-to-cart-sauce-labs-backpack';
export const username = '#user-name';
export const password = '#password';
export const loginButton = '#login-button';

test('Check the product page functionalitys', async ({ page }) => {
    await page.goto('https://www.saucedemo.com/')
    await page.locator(username).fill('standard_user');
    await page.locator(password).fill('secret_sauce');
    await page.locator(loginButton).click();

   // 

    await page.locator(backPackAddToCartBtn).click();
    await page.waitForTimeout(4000);
})
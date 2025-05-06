import { test as base } from '@playwright/test';
import LoginPage from '../pages/loginPage';
import productPage from '../pages/productPage';
import basePage from '../pages/basePage';
import checkoutPage  from '../pages/checkoutPage';

const test = base.extend({
  LoginPage: async ({ page }, use) => {
    const login = new LoginPage(page);
    await use(login);
  },
  productPage:async({page},use)=>{
    const product = new productPage(page);
    await use(product);
  },
  basePage: async ({ page }, use) => {
    const login = new basePage(page);
    await use(login);
  },
  checkoutPage :async ({page},use) =>{
    const checkout =new checkoutPage(page);
    await use(checkout);
  }
});

export default test;

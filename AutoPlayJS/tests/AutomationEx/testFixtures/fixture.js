import { test as base } from '@playwright/test';
import LoginPage from '../pages/loginPage';
import productPage from '../pages/productPage';

const test = base.extend({
  loginPage: async ({ page }, use) => {
    const login = new LoginPage(page);
    await use(login);
  },
  productPage:async({page},use)=>{
    const product = new productPage(page);
    await use(product);
  }
});



export default test;

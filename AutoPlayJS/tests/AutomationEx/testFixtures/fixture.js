import { test as base } from '@playwright/test';
import LoginPage from '../pages/loginPage';
import basePage from '../pages/basePage';


const test = base.extend({
  loginPage: async ({ page }, use) => {
    const login = new LoginPage(page);
    await use(login);
  },
  basePage: async ({ page }, use) => {
    const login = new basePage(page);
    await use(login);
  }
});

export default test;

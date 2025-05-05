import { expect } from '@playwright/test';

import test from '../testFixtures/fixture';  // Import extended test from your custom fixture file
import { username, password, loginButton, ErrorMessageforPassword, WrongCredentials, ErrorMessageforUserName, login_credentials, password_creadentials } from '../pageObjects/loginPage';
import BasePage from '../pages/basePage';
import LoginPage from '../pages/loginPage';
require('dotenv').config();
import { dashboardURL } from '../../../config';





test.describe(`@smoke :login Page testing `, () => {

    test.beforeEach(async ({ loginPage }) => {
        await loginPage.openURL();
    });
    test('UI Checking', async ({ loginPage, basePage }) => {

        await test.step('verify logo visible', async () => {
            await loginPage.verifyLogo();
        })
        await test.step('Verify username and password field visible', async () => {
            await loginPage.verifyFieldsIsVisible(username);
            await loginPage.verifyFieldsIsVisible(password);
            await loginPage.verifyFieldsIsVisible(loginButton);
            await loginPage.verifyFieldsIsVisible(login_credentials);
            await loginPage.verifyFieldsIsVisible(password_creadentials);

        })
        await test.step('Verify Login Button is Enable', async () => {
            await loginPage.verifyFieldIsEnable(loginButton);
        })
        await test.step('Verify Error Message is Visible', async () => {
            await basePage.waitAndFill(username, 'test')
            await basePage.clickMethod(loginButton)
            await loginPage.verifyErrorMessageDisplay(ErrorMessageforPassword)
            await basePage.clearText(username)
            await basePage.clickMethod(loginButton)
            await loginPage.verifyErrorMessageDisplay(ErrorMessageforUserName)

        })
        await test.step('Verify login credentials', async () => {
            await basePage.waitAndFill(username, process.env.USERNAME)
            await basePage.waitAndFill(password, process.env.WRONG_PASSWORD)
            await basePage.clickMethod(loginButton)

            await loginPage.verifyErrorMessageDisplay(WrongCredentials)

        })

    })


})

test.describe(`@Smoke2 : AFter Login Testcase`, () => {
    test.beforeEach(async ({ loginPage }) => {
        await loginPage.openURL();
    });
    test('After login ', async ({ loginPage, basePage }) => {
        await test.step('Verify login Successfully', async () => {
            await basePage.waitAndFill(username, process.env.USERNAME1)
            await basePage.waitAndFill(password, process.env.PASSWORD)
            await basePage.clickMethod(loginButton)
            await basePage.waitForPageLoad();
            await basePage.verifyUrl(dashboardURL)
        })
    })
})
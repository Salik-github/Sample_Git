import { expect } from '@playwright/test';
import test from '../testFixtures/fixture';  // Import extended test from your custom fixture file
import { username, password, loginButton, ErrorMessageforPassword, WrongCredentials, ErrorMessageforUserName, login_credentials, password_creadentials } from '../pageObjects/loginPage';
require('dotenv').config();
import { dashboardURL } from '../../../config';

test.describe(`@smoke :login Page testing `, () => {
    test.beforeEach(async ({ LoginPage }) => {
        await LoginPage.openURL();
    });
    test('UI Checking', async ({ LoginPage, basePage }) => {

        await test.step('verify logo visible', async () => {
            await LoginPage.verifyLogo();
        })
        await test.step('Verify username and password field visible', async () => {
            await LoginPage.verifyFieldsIsVisible(username);
            await LoginPage.verifyFieldsIsVisible(password);
            await LoginPage.verifyFieldsIsVisible(loginButton);
            await LoginPage.verifyFieldsIsVisible(login_credentials);
            await LoginPage.verifyFieldsIsVisible(password_creadentials);
        })
        await test.step('Verify Login Button is Enable', async () => {
            await LoginPage.verifyFieldIsEnable(loginButton);
        })
        await test.step('Verify Error Message is Visible', async () => {
            await basePage.waitAndFill(username, 'test')
            await basePage.clickMethod(loginButton)
            await LoginPage.verifyErrorMessageDisplay(ErrorMessageforPassword)
            await basePage.clearText(username)
            await basePage.clickMethod(loginButton)
            await LoginPage.verifyErrorMessageDisplay(ErrorMessageforUserName)
        })
        await test.step('Verify login credentials', async () => {
            await basePage.waitAndFill(username, process.env.USERNAME)
            await basePage.waitAndFill(password, process.env.WRONG_PASSWORD)
            await basePage.clickMethod(loginButton)
            await LoginPage.verifyErrorMessageDisplay(WrongCredentials)
        })
    })
})

test.describe(`@Smoke2 : AFter Login Testcase`, () => {
    test.beforeEach(async ({ LoginPage }) => {
        await LoginPage.openURL();
    });
    test('After login ', async ({ LoginPage, basePage }) => {
        await test.step('Verify login Successfully', async () => {
            await basePage.waitAndFill(username, process.env.USERNAME1)
            await basePage.waitAndFill(password, process.env.PASSWORD)
            await basePage.clickMethod(loginButton)
            await basePage.waitForPageLoad();
            await basePage.verifyUrl(dashboardURL)
        })
    })
})
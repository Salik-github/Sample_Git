import { expect } from '@playwright/test';

import test from '../testFixtures/fixture';  // Import extended test from your custom fixture file
import { username,password,loginButton,login_credentials,password_creadentials } from '../pageObjects/loginPage';



test.describe(`@smoke :login Page testing `, () => {

    test('UI Checking', async ({ loginPage  }) => {

        await test.step('verify url launch',async()=>{
            await loginPage.openURL();
        }) 
        await test.step('verify logo visible',async()=>{
            await loginPage.verifyLogo();
        })
        await test.step('Verify username and password field visible', async()=>{
            await loginPage.verifyFieldsIsVisible(username);
            await loginPage.verifyFieldsIsVisible(password);
            await loginPage.verifyFieldsIsVisible(loginButton);
            await loginPage.verifyFieldsIsVisible(login_credentials);
            await loginPage.verifyFieldsIsVisible(password_creadentials);

        })
        await test.step('Verify Login Button is Enable',async()=>{
            await loginPage.verifyFieldIsEnable(loginButton);
        })
    })


})
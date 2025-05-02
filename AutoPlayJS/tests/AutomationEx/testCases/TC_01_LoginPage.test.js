import { expect } from '@playwright/test';


import test from '../testFixtures/fixture';  // Import extended test from your custom fixture file



test.describe(`@smoke :login Page testing `, () => {

    test('UI Checking', async ({ loginPage  }) => {

        await test.step('verify url launch',async()=>{
            await loginPage.openURL();
        }) 
        await test.step('verify logo visible',async()=>{
            await loginPage.verifyLogo();
        })
    })

});/home/prakashni/Music/AutoPlayJS/tests/AutomationEx/pages/basePage.js
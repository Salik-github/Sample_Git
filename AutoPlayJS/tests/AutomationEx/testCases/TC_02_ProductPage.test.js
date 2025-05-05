import {expert} from '@playwright/test';

import test from '../testFixtures/fixture';
import LoginPage from '../pages/loginPage';
import productPage from '../pages/productPage';



test.describe(`@SecondTestCase : Verify Product Page `,()=>{
    test('Product Page Functionality and UI checkin ',async({LoginPage,productPage})=>{
        await test.step ('verify icons are visible',async()=>{
            await productPage.veriverifyCardIconVisible();
        })
    })
} )

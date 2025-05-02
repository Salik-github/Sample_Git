import BasePage from './basePage';
import { baseURL } from '../../../config';

import { loginpageLogo, loginButton, username, password, login_credentials, password_creadentials } from '../pageObjects/loginPage';
export default class LoginPage extends BasePage {

    constructor(page)
    {
        super (page);
    }
    async openURL()
    {
        await this.launchUrl(baseURL);
        return await this.waitForPageLoad();
        await this.verifyUrl(baseURL);
    }
    async verifyLogo()
    {
        await this.verifyitsVisible(loginpageLogo);
    }
}
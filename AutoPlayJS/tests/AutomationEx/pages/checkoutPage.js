import BasePage from './basePage'
import { checkout } from '../pageObjects/checkoutPage'

export default class checkoutPage extends BasePage {
    constructor(page) {
        super(page)
    }
    async click_checkoutPage() {
        await this.clickMethod(checkout)
    }
    async enterUserDetails(selector, value) {
        await this.waitAndFill(selector, value)
    }
}
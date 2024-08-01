package pages;

import constants.IConstants;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage implements IConstants {

    /**
     * Instantiates a new Base page.
     *
     * @param driver the driver
     */
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutOverviewPage openPage(){
        driver.get(CART_PAGE_URL);
        return this;
    }
}

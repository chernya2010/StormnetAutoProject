package pages;

import constants.IConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutInfoPage extends BasePage implements IConstants {
    @FindBy(xpath = "//input[@id='first-name']")
    WebElement firstNameInput;
    @FindBy(xpath = "//input[@id='last-name']")
    WebElement lastNameInput;
    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement zipCodeInput;
    @FindBy(xpath = "//input[@id='continue']")
    WebElement continueButton;
    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorMessage;

    /**
     * Instantiates a new Checkout page 1.
     *
     * @param driver the driver
     */
    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Open page checkout page 1.
     *
     * @return the checkout page 1
     */
    public CheckoutInfoPage openPage(){
        driver.get(CART_PAGE_URL);
        return this;
    }

    /**
     * Fill all fields with correct data on first checkout page.
     *
     * @param firstname the firstname
     * @param lastname  the lastname
     * @param zipCode   the zip code
     */
    public CheckoutOverviewPage fillAllFieldsWithCorrectData(String firstname, String lastname, String zipCode){
        firstNameInput.sendKeys(firstname);
        lastNameInput.sendKeys(lastname);
        zipCodeInput.sendKeys(zipCode);
        continueButton.click();
        return new CheckoutOverviewPage(driver);
    }

    /**
     * Fill fields withouts first name.
     *
     * @param lastname the lastname
     * @param zipCode  the zip code
     */
    public CheckoutInfoPage fillFieldsWithoutsFirstName(String lastname, String zipCode){
        lastNameInput.sendKeys(lastname);
        zipCodeInput.sendKeys(zipCode);
        continueButton.click();
        return new CheckoutInfoPage(driver);
    }

    /**
     * Get error message text string.
     *
     * @return the string
     */
    public String getErrorMessageText(){
        return errorMessage.getText();
    }
}

package pages;

import constants.IConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage implements IConstants {

    @FindBy(xpath = "/html//input[@id='user-name']")
    WebElement usernameInput;
    @FindBy(xpath = "/html//input[@id='password']")
    WebElement passwordInput;
    @FindBy(xpath = "/html//input[@id='login-button']")
    WebElement loginButton;
    @FindBy(xpath = "//*[@data-test='error']")
    WebElement errorMessage;

    /**
     * Instantiates a new Login page.
     *
     * @param driver the driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Open page.
     */
    public LoginPage openPage(){
        driver.get(LOGIN_PAGE_URL);
        return this;
    }

    /**
     * Login.
     *
     * @param username the username
     * @param password the password
     */
    public ProductsPage login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new ProductsPage(driver);
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

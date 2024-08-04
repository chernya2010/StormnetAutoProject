package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    static WebDriver driver;

    /**
     * Instantiates a new Base page.
     *
     * @param driver the driver
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Open page.
     *
     * @param url the url
     */
    public void openPage(String url){
        driver.get(url);
    }


}

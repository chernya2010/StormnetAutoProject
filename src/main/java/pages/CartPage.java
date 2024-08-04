package pages;

import constants.IConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends HeaderPage implements IConstants {

    public static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class='cart_item']";
    public static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class='inventory_item_price']";
    public static final String PRODUCT_REMOVE = PRODUCT_ITEM + "//button";
    public static final String PRODUCTS_CONTAINER = "//*[@class='cart_item']";
    public static final String CHECKOUT_BUTTON = "//button[@id='checkout']";

    /**
     * Instantiates a new Cart page.
     *
     * @param driver the driver
     */
    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Open page cart page.
     *
     * @return the cart page
     */
    public CartPage openPage(){
        driver.get(CART_PAGE_URL);
        return this;
    }

    /**
     * Remove product from cart.
     *
     * @param productName the product name
     */
    public CartPage removeProductFromCart(String productName){
        driver.findElement(By.xpath(String.format(PRODUCT_REMOVE, productName))).click();
        return this;
    }

    /**
     * Get product price string.
     *
     * @param productName the product name
     * @return the string
     */
    public String getProductPrice(String productName){
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    /**
     * Get products count int.
     *
     * @return the int
     */
    public int getProductsCount(){
       return driver.findElements(By.xpath(PRODUCTS_CONTAINER)).size();
    }

    /**
     * Is product displayed boolean.
     *
     * @param productName the product name
     * @return the boolean
     */
    public boolean isProductDisplayed(String productName){
        return !driver.findElements(By.xpath(String.format(PRODUCT_ITEM, productName))).isEmpty();
    }

    /**
     * Proceed to checkout.
     */
    public CheckoutInfoPage proceedToCheckout(){
        driver.findElement(By.xpath(CHECKOUT_BUTTON)).click();
        return new CheckoutInfoPage(driver);
    }
}

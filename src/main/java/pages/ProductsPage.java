package pages;

import constants.IConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends HeaderPage implements IConstants {
    public static final By PRODUCTS = By.xpath("//*[@data-test='title']");
    public static final String SORT_BUTTON = "//select[@class='product_sort_container']";
    public static final String SORT_LIST_Z_A = "Name (Z to A)";
    public static final String CART_BUTTON = "//a[@class='shopping_cart_link']";
//TODO:
    @FindAll({@FindBy(xpath = "//div[@class='inventory_list']")})
    static List<WebElement> productItem;
    @FindBy(xpath = "//button[contains(text(), 'Add')]")
    WebElement addProductToCartButton;
    @FindBy(xpath = "//button[contains(text(), 'Remove')]")
    WebElement removeProductFromCartButton;

    /**
     * Instantiates a new Products page.
     *
     * @param driver the driver
     */
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Open page products page.
     *
     * @return the products page
     */
    public ProductsPage openPage(){
        driver.get(PRODUCTS_PAGE_URL);
        return this;
    }

    /**
     * Get product text string.
     *
     * @return the string
     */
    public String getProductText(){
        return driver.findElement(By.xpath(String.valueOf(PRODUCTS))).getText();
    }

    /**
     * Add product to cart.
     *
     * @param productName the product name
     */
    public ProductsPage addProductToCart(String productName){
        addProductToCartButton.click();
        return this;
    }

    /**
     * Is add to cart button displayed boolean.
     * @return the boolean
     */
    public boolean isAddToCartButtonDisplayed(){
        return addProductToCartButton.isDisplayed();
    }

    /**
     * Is remove button displayed boolean.
     * @return the boolean
     */
    public boolean isRemoveButtonDisplayed(){
        return removeProductFromCartButton.isDisplayed();
    }

    /**
     * Sort by.
     *
     * @param sortValue the sort value
     */
    public void sortByValue(String sortValue){
        new Select(driver.findElement(By.xpath(SORT_BUTTON))).selectByVisibleText(sortValue);
    }

    /**
     * Get product names list.
     *
     * @return the list
     */
    public static List<String> getProductNames(){
        List<String> names = new ArrayList<>();
        List<WebElement> products = productItem;
        for (WebElement product : products)
        {
            names.add(product.getText());
        }

        return names;
    }

    /**
     * Is list sorted boolean.
     *
     * @param list the list
     * @return the boolean
     */
    public boolean isListSorted(List<String> list){
        String last = list.get(0);
        for (int i = 1; i < list.size(); i++){
            String current = list.get(i);
            if (last.compareToIgnoreCase(current) > 0){
                return false;
            }
            last = current;
        }
        return true;
    }
}

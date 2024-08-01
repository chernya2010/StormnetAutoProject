package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.constants.ITestConstants;
import static pages.ProductsPage.*;


public class ProductPageTests extends BaseTest implements ITestConstants {

    /**
     * Sort the list of products in reverse order test.
     */
    @Test
    public void sortTheListOfProductsInReverseOrderTest(){
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD);
        productsPage.sortByValue(SORT_LIST_Z_A);
        Assert.assertTrue(productsPage.isListSorted(getProductNames()));
    }
}

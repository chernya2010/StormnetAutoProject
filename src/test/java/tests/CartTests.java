package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.constants.ITestConstants;

import static constants.IConstants.CHECKOUT_PAGE1_URL;
import static constants.IConstants.CHECKOUT_PAGE2_URL;

public class CartTests extends BaseTest implements ITestConstants {

    /**
     * Successfully adding product to cart test.
     */
    @Test
    public void successfullyAddingProductToCartTest(){
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD);
        productsPage
                .addProductToCart("Sauce Labs Backpack");
        cartPage
                .openPage();
        Assert.assertEquals(cartPage.getProductsCount(), 1);
    }

    /**
     * Successful transition to next order form test.
     */
    @Test
    public void SuccessfulTransitionToNextOrderFormTest(){
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD);
        productsPage
                .addProductToCart("Sauce Labs Backpack");
        cartPage
                .openPage()
                .proceedToCheckout();
        checkoutPage1
                .fillAllFieldsWithCorrectData(FIRST_NAME, LAST_NAME, ZIP_CODE);
        Assert.assertEquals(CHECKOUT_PAGE2_URL, driver.getCurrentUrl());
    }

    /**
     * Attempt to continue placing an order with blank first name field test.
     */
    @Test
    public void AttemptToContinuePlacingAnOrderWithBlankFirstNameFieldTest() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD);
        productsPage
                .addProductToCart("Sauce Labs Backpack");
        cartPage
                .openPage()
                .proceedToCheckout();
        checkoutPage1
                .fillFieldsWithoutsFirstName(LAST_NAME, ZIP_CODE);
        Assert.assertEquals(CHECKOUT_PAGE1_URL, driver.getCurrentUrl());
        Assert.assertEquals(checkoutPage1.getErrorMessageText(), "Error: First Name is required");
    }
}

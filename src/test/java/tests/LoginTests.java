package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.constants.ITestConstants;

public class LoginTests extends BaseTest implements ITestConstants {

    /**
     * Login with correct data test.
     */
    @Test
    public void loginWithCorrectDataTest(){
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD);
        Assert.assertEquals(productsPage.getProductText(), "Products");
        driver.close();
    }
}

package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CheckoutPage1;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CheckoutPage1 checkoutPage1;
    CartPage cartPage;

    /**
     * Init test.
     */
    @BeforeMethod
    public void initTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        initPages();
    }

    /**
     * Init pages.
     */
    public void initPages(){
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        checkoutPage1 = new CheckoutPage1(driver);
        cartPage = new CartPage(driver);
    }

    /**
     * End test.
     */
    @AfterMethod(enabled = true)
    public void endTest(){
        driver.quit();
    }

}

package order;//import helpers.FileUtility;

import conf.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.MenuPage;
import pages.OrderPage;
import pages.ProductPage;

public class TestScenario extends BaseTest {

    @Test
            (description = "Esta prueba verifica que se puede comprar un producto")
    public void testAddLaptopToCart() {

        MenuPage menuPage = new MenuPage(driver);
        menuPage.navigateToLaptopsCategory();

        menuPage.selectSpecificLaptop("Sony vaio i5");
        ProductPage productPage = new ProductPage(driver);
        productPage.addLaptopToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.verifyCartContents("Sony vaio i5", "790");

        OrderPage orderPage = new OrderPage(driver);
        orderPage.placeOrder();

        Assert.assertTrue(orderPage.verifyPurchase().isDisplayed());
        orderPage.okPurchase();


    }
}
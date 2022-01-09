package testcases;

import base.BasePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import utilities.Constants;


public class ShippingPageTest extends BasePage {
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;
    OrderPage orderPage;
    AddressPage addressPage;
    ShippingPage shippingPage;
    PaymentPage paymentPage;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser){
        loadConfig( browser);
        homePage= new HomePage();
        loginPage=homePage.SignIn();
        accountPage=loginPage.login(rd.get_email(),rd.get_password());
        searchResultPage=accountPage.search(Constants.DRESS);
        addToCartPage=searchResultPage.get_item();
        orderPage=addToCartPage.pick_item(Constants.QUANTITY,Constants.SIZE);
        addressPage=orderPage.checkoutBtn();
        shippingPage=addressPage.confirmAddress();
    }
    @Test
    public void shipping_test(){
        logger.info("Shipping Test : (agree to the terms) &(Move to Payment page)");
        paymentPage=shippingPage.clickBtn();

    }

    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }
}

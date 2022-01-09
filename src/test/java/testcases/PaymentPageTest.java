package testcases;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utilities.Constants;


public class PaymentPageTest extends BasePage {
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
        orderPage =addToCartPage.pick_item(Constants.QUANTITY,Constants.SIZE);
        addressPage= orderPage.checkoutBtn();
        shippingPage=addressPage.confirmAddress();
        paymentPage=shippingPage.clickBtn();

    }

    @Test(priority = 1)
    public void PaymentTest(){
         logger.info("Test: paymentTest");
        paymentPage.clickCheckBtn();
         logger.info("Verifying Check payment");
        Assert.assertEquals(Constants.CHECK,paymentPage.getCheckMsg());


    }
    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }
}

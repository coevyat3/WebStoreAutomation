package testcases;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import utilities.Constants;


public class AddressPageTest extends BasePage {

    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;
    OrderPage orderPage;
    AddressPage addressPage;
    ShippingPage shippingPage;

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
    }
    @Test(priority = 1)
    public void verify_AddressPage_title(){
        logger.info("Verifying Address Page title");
        Assert.assertEquals(addressPage.getPageTitle(),Constants.ORDER_PAGE_TITLE);

    }
    @Test(priority = 2)
    public void validate_address(){
        logger.info("Verifying User Address");
        Assert.assertEquals(addressPage.getAddress(),Constants.ADDRESS);
    }

    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }
}

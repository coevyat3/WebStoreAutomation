package testcases;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utilities.Constants;

import java.text.ParseException;

public class OrderPageTest extends BasePage {
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;
    OrderPage orderPage;
    AddressPage addressPage;


   @Parameters("browser")
    @BeforeMethod()
    public void setup(String browser){
        loadConfig( browser);
        homePage=new HomePage();
        loginPage=homePage.SignIn();
        accountPage=loginPage.login(rd.get_email(), rd.get_password());
        searchResultPage=accountPage.search(Constants.DRESS);
        addToCartPage=searchResultPage.get_item();
        orderPage=addToCartPage.pick_item(Constants.QUANTITY,Constants.SIZE);

    }
    @Test(priority = 1)
    public void verify_product_available(){
        logger.info("Validate if Product is Available");
        Assert.assertTrue(orderPage.get_avail());


    }

    @Test(priority = 2)
    public void validate_product_name(){
        logger.info("Validate Product name");
        Assert.assertEquals(orderPage.get_product_name(),Constants.Blouse);

    }
    @Test(priority = 3)
    public void validate_product_size(){
        logger.info("Validate product size");
       Assert.assertTrue(orderPage.getSize().contains(Constants.SIZE));

    }



    @Test(priority = 4)
    public void validate_product_price() throws ParseException {
       logger.info("Validate Price");
        Assert.assertEquals(orderPage.get_total_price(),
                (orderPage.get_unit_price()*Double.valueOf(orderPage.get_quantity()))+ orderPage.get_tax_price()+ orderPage.get_shipping_tax());

    }







    @AfterMethod
    public void tearDown(){
        getDriver().quit();

    }
}

package testcases;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import utilities.Constants;


public class AddToCardPageTest extends BasePage {
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;
    OrderPage orderPage;


    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser){
        loadConfig( browser);
        homePage=new HomePage();
        loginPage=homePage.SignIn();
        accountPage=loginPage.login(rd.get_email(), rd.get_password());
        searchResultPage=accountPage.search(Constants.DRESS);
        addToCartPage=searchResultPage.get_item();

    }
    @Test(priority = 1)
    public void verify_Add_to_cartPage_title(){
        logger.info("Verify Add to cart page title");
        Assert.assertEquals(addToCartPage.get_PageTitle(), Constants.ADD_TO_CART_PAGE_TITLE);

    }
    @Test(priority = 2)
    public void pick_quantity_size(){
        logger.info("Test: pick product quantity & size");
        orderPage=  addToCartPage.pick_item(Constants.QUANTITY,Constants.SIZE);
        if(orderPage.get_pageTitle().equals(Constants.ORDER_PAGE_TITLE)){
              logger.info("Test successes & move to OrderPage");
        }
        else {
              logger.info("Test failed ");
        }

    }


    @AfterMethod
    public void tearDown(){
        getDriver().quit();;
    }
}

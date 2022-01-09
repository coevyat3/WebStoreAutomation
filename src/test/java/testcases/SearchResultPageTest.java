package testcases;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import utilities.Constants;

import java.util.Locale;

public class SearchResultPageTest extends BasePage {
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;

   @Parameters("browser")
    @BeforeMethod
    public void setup(String browser){
        loadConfig( browser);
        homePage= new HomePage();
        loginPage=homePage.SignIn();
        accountPage=loginPage.login(rd.get_email(), rd.get_password());
        searchResultPage=accountPage.search(Constants.DRESS);


    }
    @Test(priority = 1)
    public void get_pageTitle(){
        logger.info("Verifying SearchResult Page title");
        Assert.assertEquals(searchResultPage.getPageTitle(),Constants.SEARCH_RESULT_PAGE_TITLE);


    }
    @Test(priority = 2)
    public void get_resultTxt(){
        logger.info("Verifying Result text");
       Assert.assertEquals(searchResultPage.getResultTxt().toLowerCase(Locale.ROOT),Constants.DRESS);

    }
   @Test(priority = 3)
   public void pick_product()  {
        logger.info("Verifying pick Product Test");
        addToCartPage=searchResultPage.get_item();
        if(addToCartPage.get_PageTitle().contains(Constants.DRESS)){
            logger.info("Test success:Pick product  & navigate to Add to card Page");
        }
        else{
            logger.info("Failed To pick a product");
        }
   }


    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }

}

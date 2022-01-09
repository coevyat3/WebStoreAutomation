package testcases;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchResultPage;
import utilities.Constants;

public class AccountPageTest extends BasePage {
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    SearchResultPage searchResultPage;

  @Parameters("browser")
    @BeforeMethod
    public void setup(String browser){
        loadConfig( browser);
        homePage = new HomePage();
        loginPage = homePage.SignIn();
        accountPage = loginPage.login(rd.get_email(), rd.get_password());
    }

    @Test(priority = 1)
    public void verify_accountPage_title() {
         logger.info("Verifying AccountPage title");
        Assert.assertEquals(accountPage.getTile(), Constants.ACCOUNT_PAGE_TITLE);

    }

    @Test(priority = 2)
    public void verify_username_display() {
        logger.info("Verifying UserName display");
        Assert.assertTrue(accountPage.getUserName());

    }

    @Test(priority = 3)
    public void search_box_test() {
        logger.info("SearchBox Test");
        searchResultPage = accountPage.search(Constants.DRESS);
    }


    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }


}

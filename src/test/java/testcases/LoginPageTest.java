package testcases;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.Constants;





public class LoginPageTest extends BasePage {
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;

   @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) {
        loadConfig(browser);
        homePage = new HomePage();
        loginPage = homePage.SignIn();
    }
    @Test(priority = 1)
    public void verify_loginPageTitle(){
         logger.info("Verifying LoginPage title");
        Assert.assertEquals(loginPage.getPageTitle(),Constants.loginPageTitle);

    }


    @Test(dataProvider = "getLoginData" ,priority = 2)
    public void loginTest(String email, String pw)  {
        logger.info("Login Test");
        accountPage = loginPage.login(email, pw);
        if(accountPage.getTile().equals(Constants.ACCOUNT_PAGE_TITLE)){
             logger.info("Login Test Success");
        }
        else{
               logger.info("Login Test Failed");
        }


    }



    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }

}

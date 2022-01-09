package testcases;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import utilities.Constants;


public class HomePageTest extends BasePage {
      HomePage homePage;


  @Parameters("browser")
    @BeforeMethod
    public void setup(String browser){
        loadConfig( browser);
        homePage= new HomePage();
    }

    @Test(priority = 1)
    public void verify_HomePageTitle(){
        logger.info("Verify homePage title");
            Assert.assertEquals(homePage.getPageTitle(), Constants.HomePageTitle);


    }

    @Test(priority = 2)
    public void verify_HomePageLogo(){
        logger.info("Verify HomePage mail logo");
        Assert.assertTrue(homePage.getMainLogo());
    }
    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }
}

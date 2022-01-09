package base;
import io.github.bonigarcia.wdm.WebDriverManager;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import utilities.Constants;
import utilities.ReadData;
import utilities.TestUtils;
import java.io.IOException;
import java.time.Duration;


public class BasePage {
    protected static Logger logger= LogManager.getLogger("BasePage");
    protected static ReadData rd;
    protected static WebDriverWait wait;
    protected static ThreadLocal<RemoteWebDriver>driver=new ThreadLocal<>();


 @BeforeSuite
 public void setLoad(){
     PropertyConfigurator.configure("log4j.properties");
 }

    public static WebDriver getDriver(){
        return driver.get();
    }

 @Parameters("browser")
    public static void loadConfig(String browserType){

        rd=new ReadData();
       if(browserType.equals("chrome")){
           WebDriverManager.chromedriver().setup();
           ChromeOptions options= new ChromeOptions();
           options.addArguments("--headless");
           driver.set(new ChromeDriver(options));
       }
       else if(browserType.equals("Firefox")){
           WebDriverManager.firefoxdriver().setup();
           driver.set(new FirefoxDriver());
       }
        wait= new WebDriverWait(getDriver(),Duration.ofSeconds(15));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));
        getDriver().manage().window().maximize();
        getDriver().get(rd.getURL());

    }

    @DataProvider(name ="getLoginData")
    public Object[][] getData() throws IOException {
        Object data[][]= TestUtils.getData("login");

        return data;
    }


}
